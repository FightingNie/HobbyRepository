package healthyhome.action;

import healthyhome.bean.Role;
import healthyhome.bean.UserMessage;
import healthyhome.bean.UserRole;
import healthyhome.dao.RoleDao;
import healthyhome.dao.UserMessageDao;
import healthyhome.dao.UserRoleDao;
import healthyhome.util.ResponseUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManController extends BaseController {
	@Autowired
	private UserMessageDao uMDao;
	@Autowired
	private UserRoleDao URDao;
	@RequestMapping(value = "/userMan")
	public ModelAndView userMan(HttpServletRequest request) {
		List<UserMessage> uMList = uMDao.findByExample(new UserMessage());
		request.getSession().setAttribute("userList", uMList);
		return new ModelAndView("userMan");
	}
	@RequestMapping("/deleteUserById")
	public void deleteUserById(HttpServletRequest request,
			HttpServletResponse response, UserMessage um) 
					throws ParseException{
		UserMessage userMessage = uMDao.findById(um.getId(), UserMessage.class.getName());
		uMDao.delete(userMessage);
		UserRole ur = new UserRole(um.getId(),um.getRoleId());
		URDao.delete(ur);;
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/addUser")
	public void addUser(HttpServletRequest request,
			HttpServletResponse response, UserMessage um) {
		if(1 == um.getRoleId()) {
			um.setRoleName("admin");
		}else{
			um.setRoleName("simple user");
		}
		uMDao.save(um);
		UserRole ur = new UserRole(um.getId(),um.getRoleId());
		URDao.save(ur);
		try {
			ResponseUtils.write(response, "添加成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
