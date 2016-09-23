package healthyhome.action.message;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import healthyhome.action.BaseController;
import healthyhome.bean.message.SystemMessage;
import healthyhome.dao.SystemMessageDao;
import healthyhome.util.ResponseUtils;

@Controller
public class SystemMessageController extends BaseController {
	@Autowired
	private SystemMessageDao smDao;
	
	@RequestMapping(value = "/systemMessageList")
	public ModelAndView getSystemMessageList(HttpServletRequest request,
			HttpServletResponse response){
		SystemMessage instance = new SystemMessage();
		List<SystemMessage> sms = smDao.findByExample(instance);
		request.getSession().setAttribute("sms", sms);
		return new ModelAndView("message/systemMessage");
	}
	@RequestMapping(value = "/getSystemMessageById")
	public ModelAndView getSystemMessageById(HttpServletRequest request,
			HttpServletResponse response,SystemMessage systemMessage){
		List<SystemMessage> sms = smDao.findByExample(systemMessage);
		request.getSession().setAttribute("sm", sms.get(0));
		return new ModelAndView("message/showSystemMessage");
	}
	
	@RequestMapping(value = "/adminSystemMessageList")
	public ModelAndView adminSystemMessageList(HttpServletRequest request,
			HttpServletResponse response){
		SystemMessage instance = new SystemMessage();
		List<SystemMessage> sms = smDao.findByExample(instance);
		request.getSession().setAttribute("sms", sms);
		return new ModelAndView("message/adminSystemMessage");
	}
	@RequestMapping(value = "/createSystemMessageDemo")
	public ModelAndView createSystemMessageDemo(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView("message/createSystemMessage");
	}
	@RequestMapping(value = "/deleteSystemMessage")
	public void deleteSystemMessage(HttpServletRequest request,
			HttpServletResponse response, SystemMessage sme)
					throws ParseException{
		SystemMessage systemMessage = smDao.findById(sme.getId(), SystemMessage.class.getName());
		smDao.delete(systemMessage);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/changeSystemMessageDemo")
	public ModelAndView changeSystemMessageDemo(HttpServletRequest request,
			SystemMessage sme) {
		SystemMessage systemMessage = smDao.findById(sme.getId(), SystemMessage.class.getName());
		request.getSession().setAttribute("systemMe", systemMessage);
		return new ModelAndView("message/changeSystemMessage");
	}
	
	@RequestMapping("/changeSystemMessage")
	public void changeSystemMessage(HttpServletRequest request,
			HttpServletResponse response, SystemMessage sme) {
		SystemMessage systemMessage = smDao.findById(sme.getId(), SystemMessage.class.getName());
		systemMessage.setContent(sme.getContent());
		systemMessage.setTitle(sme.getTitle());
		Date dt=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
	    systemMessage.setDate(matter.format(dt));
	    smDao.attachDirty(systemMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/createSystemMessage")
	public void createSystemMessage(HttpServletRequest request,
			HttpServletResponse response, SystemMessage sm) {
		Date dt = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = matter.format(dt);
		sm.setDate(dateStr);
		smDao.save(sm);
		try {
			ResponseUtils.write(response, "发布成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
