package healthyhome.action.message;

import healthyhome.action.BaseController;
import healthyhome.bean.CarHug;
import healthyhome.bean.HugCustomer;
import healthyhome.bean.Society;
import healthyhome.bean.UserMessage;
import healthyhome.bean.message.Message;
import healthyhome.bean.responseobject.MyCarHugResponseObj;
import healthyhome.dao.MessageDao;
import healthyhome.util.ResponseUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController extends BaseController {
	@Autowired
	private MessageDao mDao;

	@RequestMapping(value = "/submitMessage")
	public void submitMessage(HttpServletRequest request,
			HttpServletResponse response, Message message)
			throws ParseException {
		Date dt = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = matter.format(dt);
		message.setPublishTime(dateStr);
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		message.setPublishUserId(um.getId());
		message.setIsAnswer("no");
		String alertStr = "发布成功，请等待管理员答复";
		if(message.getType()==1){
			message.setTypeName("advice");
		}else if(message.getType()==2){
			message.setTypeName("reject");
		}else{
			alertStr = "发布成功！";
			message.setTypeName("simple message");
		}
		mDao.save(message);
		try {
			ResponseUtils.write(response, alertStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/submitMessageDemo")
	public ModelAndView submitMessageDemo(HttpServletRequest request,
			HttpServletResponse response, Message me){
		request.getSession().setAttribute("me", me);
		return new ModelAndView("carhug/carHugMessage");
	}
	@RequestMapping(value = "/deleteMyMessage")
	public void deleteMyMessage(HttpServletRequest request,
			HttpServletResponse response, Message me)
			throws ParseException {
		Message message = mDao.findById(me.getId(),Message.class.getName());
		mDao.delete(message);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/changeMyMessage")
	public void changeMyMessage(HttpServletRequest request,
			HttpServletResponse response, Message m)
			throws ParseException {
		Message message = mDao.findById(m.getId(),Message.class.getName());
		message.setContent(m.getContent());
		mDao.attachDirty(message);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "changeMyMessageDemo")
	public ModelAndView changeMyMessageDemo(HttpServletRequest request, Message m){
		request.getSession().setAttribute("message", m);
		return new ModelAndView("message/changeMyMessage");
	}
	
	@RequestMapping(value = "/myLeaveMessage")
	public ModelAndView myLeaveMessage(HttpServletRequest request,
		 Message me) throws ParseException {
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		Message m = new Message();
		m.setPublishUserId(um.getId());
		m.setContent(me.getContent());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		m.setPublishTime(date);
		m.setType(me.getType());
		if(1 == m.getType()){
			m.setTypeName("advice");
		}else{
			m.setTypeName("reject");
		}
		m.setIsAnswer("no");
		mDao.save(m);
		Message sm = new Message();
		sm.setPublishUserId(um.getId());
		List<Message> mList = mDao.findByExample(sm);
		request.getSession().setAttribute("messageList", mList);
		return new ModelAndView("message/leaveMessage");
	}
	
	@RequestMapping(value = "/myLeaveMessages")
	public ModelAndView myLeaveMessages(HttpServletRequest request,
			 Message me) throws ParseException {
			UserMessage um = (UserMessage) request.getSession()
					.getAttribute("user");
			Message sm = new Message();
			sm.setPublishUserId(um.getId());
			List<Message> mList = mDao.findByExample(sm);
			request.getSession().setAttribute("messageList", mList);
			return new ModelAndView("message/leaveMessage");
		}
	

	@RequestMapping(value = "/advice")
	public ModelAndView advice(HttpServletRequest request,
			Integer userId) throws ParseException {
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		if (um.getRoleId() == 2) {
			return new ModelAndView("message/advice");
		} else {
			Message m = new Message();
			m.setType(1);
			List<Message> mList = mDao.findByExample(m);
			request.getSession().setAttribute("adviceList", mList);
			return new ModelAndView("message/adminAdvice");
		}
	}
	
	@RequestMapping(value = "/answerAdvice")
	public void answerAdvice(HttpServletRequest request, HttpServletResponse response,Message m) throws ParseException {
		Message message = mDao.findById(m.getId(),Message.class.getName());
		message.setAnswerContent(m.getAnswerContent());
		Date dt=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		message.setAnswerTime(matter.format(dt));
		message.setIsAnswer("yes");
		mDao.attachDirty(message);
		try {
			ResponseUtils.write(response, "答复成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/ansRecMessage")
	public void answerRecieveMyMessage(HttpServletRequest request, HttpServletResponse response,Message m) throws ParseException {
		Message message = mDao.findById(m.getId(),Message.class.getName());
		message.setAnswerContent(m.getAnswerContent());
		Date dt=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		message.setAnswerTime(matter.format(dt));
		message.setIsAnswer("yes");
		mDao.attachDirty(message);
		try {
			ResponseUtils.write(response, "答复成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/reject")
	public ModelAndView reject(HttpServletRequest request,
			Integer userId) throws ParseException {
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		if (um.getRoleId() == 2) {
			return new ModelAndView("message/reject");
		} else {
			Message m = new Message();
			m.setType(2);
			List<Message> mList = mDao.findByExample(m);
			request.getSession().setAttribute("rejectList", mList);
			return new ModelAndView("message/adminReject");
		}
	}
	@RequestMapping(value = "/answerReject")
	public void answerReject(HttpServletRequest request, HttpServletResponse response,Message m) throws ParseException {
		Message message = mDao.findById(m.getId(),Message.class.getName());
		message.setAnswerContent(m.getAnswerContent());
		Date dt=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		message.setAnswerTime(matter.format(dt));
		message.setIsAnswer("yes");
		mDao.attachDirty(message);
		try {
			ResponseUtils.write(response, "处理成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
