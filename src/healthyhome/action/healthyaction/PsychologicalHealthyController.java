package healthyhome.action.healthyaction;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import healthyhome.bean.AssessmentMessage;
import healthyhome.bean.EmotionMessage;
import healthyhome.bean.ExceptionBehaviour;
import healthyhome.bean.UserMessage;
import healthyhome.dao.AssessmentMessageDao;
import healthyhome.dao.EmotionMessageDao;
import healthyhome.dao.ExceptionBehaviourDao;
import healthyhome.dao.UserMessageDao;
import healthyhome.util.ResponseUtils;

@Controller
public class PsychologicalHealthyController {
	
	@Autowired
	private ExceptionBehaviourDao excDao;
	@Autowired
	private AssessmentMessageDao asseDao;
	@Autowired
	private EmotionMessageDao emoDao;
	@Autowired
	private UserMessageDao umDao;

	@RequestMapping(value = "/showPsychologicalHealthy")
	public ModelAndView showPsychologicalHealthy(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<EmotionMessage> emotionMessages = getEmotionMessages(uid);
		List<ExceptionBehaviour> exceptionBehaviours =getExceptionBehaviours(uid);
		List<AssessmentMessage> assessmentMessages = getAssessmentMessages(uid);
		if(emotionMessages.isEmpty()){
			request.getSession().setAttribute("emomessage", "暂无记录");
		}else{
			request.getSession().setAttribute("emotionMessages", emotionMessages);
			request.getSession().setAttribute("emomessage", null);
		}
	
		if(exceptionBehaviours.isEmpty()){
			request.getSession().setAttribute("excepmessage", "暂无记录");
		}else{
			request.getSession().setAttribute("exceptionBehaviours", exceptionBehaviours);
			request.getSession().setAttribute("excepmessage", null);
		}
		
		if(assessmentMessages.isEmpty()){
			request.getSession().setAttribute("assemessage", "暂无记录");
		}else{
			request.getSession().setAttribute("assessmentMessages", assessmentMessages);
			request.getSession().setAttribute("assemessage", null);
		}
		
		return new ModelAndView("healthy/showPsychologicalHealthy");
	}
	@RequestMapping(value = "/addEmotionMessageDemo")
	public ModelAndView addEmotionMessageDemo(){
		return new ModelAndView("psychologicalHealthy/addEmotionMessage");
	}
	@RequestMapping(value = "/addExceptionBehaviourDemo")
	public ModelAndView addExceptionBehaviourDemo(){
		return new ModelAndView("psychologicalHealthy/addExceptionBehaviour");
	}
	@RequestMapping(value = "/addEmotionMessage")
	public void addEmotionMessage(HttpServletRequest request, HttpServletResponse response, EmotionMessage emo){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		try{
			EmotionMessage e = new EmotionMessage();
			e.setAngryBehaviour(emo.getAngryBehaviour());
			e.setAngryLevel(emo.getAngryLevel());
			e.setAngryTimes(emo.getAngryTimes());
			e.setHappyBehaviour(emo.getHappyBehaviour());
			e.setHappyLevel(emo.getHappyLevel());
			e.setHappyTimes(emo.getHappyTimes());
			e.setSadTimes(emo.getSadTimes());
			e.setUid(uid);
			emoDao.save(e);
			ResponseUtils.write(response, "添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addExceptionBehaviour")
	public void addExceptionBehaviour(HttpServletRequest request, HttpServletResponse response, ExceptionBehaviour exc){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		try{
			ExceptionBehaviour exce = new ExceptionBehaviour();
			exce.setBehaviour(exc.getBehaviour());
			exce.setDate(exc.getDate());
			exce.setUid(uid);
			excDao.save(exce);
			ResponseUtils.write(response, "添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/healthyAssessment")
	public void healthyAssessment(){
		AssessmentMessage as = new AssessmentMessage();
		as.setAssessment("A");
		asseDao.attachDirty(as);
		List<UserMessage> ums = umDao.findByExample(new UserMessage());
		List<AssessmentMessage> ass = null;
	}
	
	private List<EmotionMessage> getEmotionMessages(int uid){
		EmotionMessage emo = new EmotionMessage();
		emo.setUid(uid);
		List<EmotionMessage> emos = emoDao.findByUid(emo);
		if(emos.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return emos;
	}
	
	private List<ExceptionBehaviour> getExceptionBehaviours(int uid){
		ExceptionBehaviour exc = new ExceptionBehaviour();
		exc.setUid(uid);
		List<ExceptionBehaviour> excs = excDao.findByExample(exc);
		if(excs.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return excs;
	}
	
	private List<AssessmentMessage> getAssessmentMessages(int uid){
		AssessmentMessage asse = new AssessmentMessage();
		asse.setUid(uid);
		List<AssessmentMessage> asses = asseDao.findByExample(asse);
		if(asses.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return asses;
	}
}
