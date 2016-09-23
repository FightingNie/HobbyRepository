package healthyhome.action.healthyaction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import healthyhome.bean.BMessage;
import healthyhome.bean.BloodMessage;
import healthyhome.bean.ChestRay;
import healthyhome.bean.EarMessage;
import healthyhome.bean.ExternalMessage;
import healthyhome.bean.EyeMessage;
import healthyhome.bean.InternalMessage;
import healthyhome.bean.LiverMessage;
import healthyhome.bean.UserMessage;
import healthyhome.dao.BMessageDao;
import healthyhome.dao.BloodMessageDao;
import healthyhome.dao.ChestRayDao;
import healthyhome.dao.EarMessageDao;
import healthyhome.dao.ExternalMessageDao;
import healthyhome.dao.EyeMessageDao;
import healthyhome.dao.InternalMessageDao;
import healthyhome.dao.LiverMessageDao;
import healthyhome.dao.UserMessageDao;
import healthyhome.util.ResponseUtils;
import healthyhome.vo.BodyDetails;

@Controller
public class HealthyExaminationController {
	
	@Autowired
	private EyeMessageDao emDao;
	@Autowired
	private InternalMessageDao imDao;
	@Autowired
	private ExternalMessageDao exmDao;
	@Autowired
	private EarMessageDao earDao;
	@Autowired
	private BloodMessageDao bmDao;
	@Autowired
	private ChestRayDao crDao;
	@Autowired
	private BMessageDao bMessageDao;
	@Autowired
	private LiverMessageDao lmDao;
	@Autowired
	private UserMessageDao umDao;
	@RequestMapping(value = "/eyeExamDetail")
	public ModelAndView eyeExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();

		EyeMessage em = getEyeMessage(uid, bdId);
		
		request.getSession().setAttribute("em", em);
		return new ModelAndView("healthy/eyeExamDetail");
	}
	
	@RequestMapping(value = "/liverExamDetail")
	public ModelAndView liverExamDetail(HttpServletRequest request,LiverMessage lm){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		lm.setUid(uid);
		LiverMessage liverMessage = (LiverMessage) lmDao.findByUidAndId(lm).get(0);
		request.getSession().setAttribute("lm", liverMessage);
		return new ModelAndView("healthy/liverExamDetail");

	}
	@RequestMapping(value = "/bExamDetail")
	public ModelAndView bExamDetail(HttpServletRequest request,BMessage bMessage){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		bMessage.setUid(uid);
		BMessage bMe = (BMessage) bMessageDao.findByUidAndId(bMessage).get(0);
		request.getSession().setAttribute("bMe", bMe);
		return new ModelAndView("healthy/bExamDetail");

	}
	@RequestMapping(value = "/chestExamDetail")
	public ModelAndView chestExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();
//		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("login", "message", "暂无记录");
//		}
		ChestRay cr = getChestRay(uid, bdId);
//		BodyDetails bodyDetail = new BodyDetails();
//		bodyDetail.setId(bdId);
//		bodyDetail.setUid(uid);
//		bodyDetail.setChestX(cr.getChestX());
//		bodyDetail.setChestInspector(cr.getChestInspector());
//		bodyDetail.setDate(cr.getDate());
		request.getSession().setAttribute("cr", cr);
		return new ModelAndView("healthy/chestExamDetail");
	}
	@RequestMapping(value = "/bloodExamDetail")
	public ModelAndView bloodExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();
//		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("login", "message", "暂无记录");
//		}
		BloodMessage bm = getBloodMessage(uid, bdId);
		
//		BodyDetails bodyDetail = new BodyDetails();
//		bodyDetail.setId(bdId);
//		bodyDetail.setUid(uid);
//		bodyDetail.setBlood(bm.getBlood());
//		bodyDetail.setBloodInspector(bm.getBloodInspector());
//		bodyDetail.setDate(bm.getDate());
		request.getSession().setAttribute("bm", bm);
		return new ModelAndView("healthy/bloodExamDetail");
	}
	@RequestMapping(value = "/earExamDetail")
	public ModelAndView earExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();
//		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("login", "message", "暂无记录");
//		}
		EarMessage eam = getEarMessage(uid, bdId);
//		BodyDetails bodyDetail = new BodyDetails();
//		bodyDetail.setId(bdId);
//		bodyDetail.setUid(uid);
//		bodyDetail.setRightEar(eam.getRightEar());
//		bodyDetail.setEarInspector(eam.getEarInspector());
//		bodyDetail.setDate(eam.getDate());
		request.getSession().setAttribute("eam", eam);
		return new ModelAndView("healthy/earExamDetail");
	}
	@RequestMapping(value = "/externalExamDetail")
	public ModelAndView externalExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();
//		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("login", "message", "暂无记录");
//		}
		ExternalMessage exm = getExternalMessage(uid, bdId);
//		BodyDetails bodyDetail = new BodyDetails();
//		bodyDetail.setId(bdId);
//		bodyDetail.setUid(uid);
//		bodyDetail.setHeight(exm.getHeight());
//		bodyDetail.setWeight(exm.getWeight());
//		bodyDetail.setSkin(exm.getSkin());
//		bodyDetail.setExtremitiesAndSpine(exm.getExtremitiesAndSpine());
//		bodyDetail.setOthers(exm.getOthers());
//		bodyDetail.setExternalInspector(exm.getExternalInspector());
//		bodyDetail.setDate(exm.getDate());
		request.getSession().setAttribute("exm", exm);
		return new ModelAndView("healthy/externalExamDetail");
	}
	@RequestMapping(value = "/internalExamDetail")
	public ModelAndView internalExamDetail(HttpServletRequest request, BodyDetails bd){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		int bdId = bd.getId();
//		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("login", "message", "暂无记录");
//		}
		InternalMessage im = getInternalMessage(uid, bdId);
//		BodyDetails bodyDetail = new BodyDetails();
//		bodyDetail.setId(bdId);
//		bodyDetail.setUid(uid);
//		bodyDetail.setBloodPressure(im.getBloodPressure());
//		bodyDetail.setHeartAndLung(im.getHeartAndLung());
//		bodyDetail.setInternalInspector(im.getInternalInspector());
//		bodyDetail.setDate(im.getDate());
		request.getSession().setAttribute("im", im);
		return new ModelAndView("healthy/internalExamDetail");
	}
	@RequestMapping(value = "/internalExamination")
	public ModelAndView internalExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<InternalMessage> ims = getInternalMessage(uid);
//		if(ims.isEmpty()){
//			return new ModelAndView("healthy/internalExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(ims.size());
		int time = 1;
		for(InternalMessage im : ims){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(im.getId());
			bd.setDate(im.getDate());
			bd.setUid(im.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/internalExam");
	}
	
	@RequestMapping(value = "/externalExamination")
	public ModelAndView externalExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<ExternalMessage> ems = getExternalMessage(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("healthy/externalExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(ems.size());
		int time = 1;
		for(ExternalMessage em : ems){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(em.getId());
			bd.setDate(em.getDate());
			bd.setUid(em.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/externalExam");
	}
	
	@RequestMapping(value = "/earExamination")
	public ModelAndView earExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<EarMessage> ems = getEarMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("healthy/earExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(ems.size());
		int time = 1;
		for(EarMessage em : ems){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(em.getId());
			bd.setDate(em.getDate());
			bd.setUid(em.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/earExam");
	}
	
	@RequestMapping(value = "/bloodExamination")
	public ModelAndView bloodExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<BloodMessage> bms = getBloodMessages(uid);
//		if(bms.isEmpty()){
//			return new ModelAndView("healthy/bloodExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(bms.size());
		int time = 1;
		for(BloodMessage bm : bms){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(bm.getId());
			bd.setDate(bm.getDate());
			bd.setUid(bm.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/bloodExam");
	}
	
	@RequestMapping(value = "/chestExamination")
	public ModelAndView chestExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("healthy/chestExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(ems.size());
		int time = 1;
		for(EyeMessage em : ems){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(em.getId());
			bd.setDate(em.getDate());
			bd.setUid(em.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/chestExam");
	}
	@RequestMapping(value = "/bExamination")
	public ModelAndView bExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<BMessage> bMessages = getBMessages(uid);
		if(!bMessages.isEmpty()){
			request.getSession().setAttribute("bMessages", bMessages);
			return new ModelAndView("healthy/bExam");
		}
		return new ModelAndView("healthy/bExam");
	}
	
	@RequestMapping(value = "/liverExamination")
	public ModelAndView liverExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<LiverMessage> lms = getLiverMessages(uid);
		if(lms.isEmpty()){
//			return new ModelAndView("healthy/liverExam", "message", "暂无记录");
//		}else{
			request.getSession().setAttribute("lms", lms);
			return new ModelAndView("healthy/liverExam");
		}
		return new ModelAndView("healthy/liverExam");
	}
	@RequestMapping(value = "/eyeExamination")
	public ModelAndView eyeExamination(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<EyeMessage> ems = getEyeMessages(uid);
//		if(ems.isEmpty()){
//			return new ModelAndView("healthy/eyeExam", "message", "暂无记录");
//		}
		List<BodyDetails> bds = new ArrayList<BodyDetails>(ems.size());
		int time = 1;
		for(EyeMessage em : ems){
			BodyDetails bd = new BodyDetails();
			bd.setTimes(time);
			bd.setId(em.getId());
			bd.setDate(em.getDate());
			bd.setUid(em.getUid());
			bds.add(bd);
			time++;
		}
		request.getSession().setAttribute("bodyBetails", bds);
		return new ModelAndView("healthy/eyeExam");
	}
	@RequestMapping(value = "/searchEyeMessage")
	public ModelAndView searchEyeMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		EyeMessage em = new EyeMessage();
		em.setDate(date);
		em.setUid(u.getId());
		if(emDao.findByUidAndDate(em).isEmpty()){
			request.getSession().setAttribute("em", null);
			return new ModelAndView("healthy/adminSearchEyeMessage", "message", "暂无记录");
		}
		EyeMessage eyeMessage = (EyeMessage) emDao.findByUidAndDate(em).get(0);
		request.getSession().setAttribute("em", eyeMessage);
		return new ModelAndView("healthy/adminSearchEyeMessage");
	}
	
	@RequestMapping(value = "/searchInternalMessage")
	public ModelAndView searchInternalMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		InternalMessage em = new InternalMessage();
		em.setDate(date);
		em.setUid(u.getId());
		if(imDao.findByExample(em).isEmpty()){
			request.getSession().setAttribute("im", null);
			return new ModelAndView("healthy/adminSearchInternalMessage", "message", "暂无记录");
		}
		InternalMessage internalMessage = (InternalMessage) imDao.findByExample(em).get(0);
		request.getSession().setAttribute("im", internalMessage);
		return new ModelAndView("healthy/adminSearchInternalMessage");
	}
	@RequestMapping(value = "/searchExternalMessage")
	public ModelAndView searchExternalMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		ExternalMessage em = new ExternalMessage();
		em.setDate(date);
		em.setUid(u.getId());
		if(exmDao.findByUidAndDate(em).isEmpty()){
			request.getSession().setAttribute("exm", null);
			return new ModelAndView("healthy/adminSearchExternalMessage", "message", "暂无记录");
		}
		ExternalMessage internalMessage = (ExternalMessage) exmDao.findByUidAndDate(em).get(0);
		request.getSession().setAttribute("exm", internalMessage);
		return new ModelAndView("healthy/adminSearchExternalMessage");
	}
	@RequestMapping(value = "/searchEarMessage")
	public ModelAndView searchEarMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		EarMessage em = new EarMessage();
		em.setDate(date);
		em.setUid(u.getId());
		if(earDao.findByUidAndDate(em).isEmpty()){
			request.getSession().setAttribute("earm", null);
			return new ModelAndView("healthy/adminSearchEarMessage", "message", "暂无记录");
		}
		EarMessage internalMessage = (EarMessage) earDao.findByUidAndDate(em).get(0);
		request.getSession().setAttribute("earm", internalMessage);
		return new ModelAndView("healthy/adminSearchEarMessage");
	}
	@RequestMapping(value = "/searchBloodMessage")
	public ModelAndView searchBloodMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		BloodMessage em = new BloodMessage();
		em.setDate(date);
		em.setUid(u.getId());
		request.getSession().setAttribute("cardNo", cardNo);
		if(bmDao.findByUidAndDate(em).isEmpty()){
			request.getSession().setAttribute("bm", null);
			return new ModelAndView("healthy/adminSearchBloodMessage", "message", "暂无记录");
		}
		BloodMessage internalMessage = (BloodMessage) bmDao.findByUidAndDate(em).get(0);
		request.getSession().setAttribute("bm", internalMessage);
		return new ModelAndView("healthy/adminSearchBloodMessage");
	}
	@RequestMapping(value = "/searchLiverMessage")
	public ModelAndView searchLiverMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, String date){
		UserMessage userMessage = new UserMessage();
		userMessage.setCardNo(cardNo);
		UserMessage u = umDao.findByExample(userMessage).get(0);
		LiverMessage em = new LiverMessage();
		em.setDate(date);
		em.setUid(u.getId());
		request.getSession().setAttribute("cardNo", cardNo);
		if(lmDao.findByUidAndDate(em).isEmpty()){
			request.getSession().setAttribute("lm", null);
			return new ModelAndView("healthy/adminSearchLiverMessage", "message", "暂无记录");
		}
		LiverMessage liverMessage = (LiverMessage) lmDao.findByUidAndDate(em).get(0);
		request.getSession().setAttribute("lm", liverMessage);
		return new ModelAndView("healthy/adminSearchLiverMessage");
	}
	@RequestMapping(value = "/delEyeMessage")
	public void delEyeMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		EyeMessage eyeMessage = new EyeMessage();
		eyeMessage.setId(id);
		EyeMessage em = (EyeMessage) emDao.findById(eyeMessage).get(0);
		emDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/delInternalMessage")
	public void delInternalMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		InternalMessage internalMessage = new InternalMessage();
		internalMessage.setId(id);
		InternalMessage em = (InternalMessage) imDao.findById(internalMessage).get(0);
		imDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/delExternalMessage")
	public void delExternalMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		ExternalMessage externalMessage = new ExternalMessage();
		externalMessage.setId(id);
		ExternalMessage em = (ExternalMessage) exmDao.findById(externalMessage).get(0);
		exmDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/delEarMessage")
	public void delEarMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		EarMessage earMessage = new EarMessage();
		earMessage.setId(id);
		EarMessage em = (EarMessage) earDao.findById(earMessage).get(0);
		earDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/delBloodMessage")
	public void delBloodMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		BloodMessage bloodMessage = new BloodMessage();
		bloodMessage.setId(id);
		BloodMessage em = (BloodMessage) bmDao.findById(bloodMessage).get(0);
		bmDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delLiverMessage")
	public void delLiverMessage(HttpServletRequest request,
			HttpServletResponse response, Integer id){
		LiverMessage liverMessage = new LiverMessage();
		liverMessage.setId(id);
		LiverMessage em = (LiverMessage) lmDao.findById(liverMessage).get(0);
		lmDao.delete(em);
		try {
			ResponseUtils.write(response, "删除成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/submitEyeMessage")
	public void submitEyeMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, EyeMessage em){
		UserMessage um = new UserMessage();
		um.setCardNo(cardNo);
		try {
			if(umDao.findByExample(um).isEmpty()){
				ResponseUtils.write(response, "用户不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		UserMessage userMessage = umDao.findByExample(um).get(0);
		em.setUid(userMessage.getId());
		emDao.save(em);
		try {
			ResponseUtils.write(response, "添加成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/submitInternalMessage")
	public void submitInternalMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, InternalMessage em){
		UserMessage um = new UserMessage();
		um.setCardNo(cardNo);
		try {
			if(umDao.findByExample(um).isEmpty()){
				ResponseUtils.write(response, "用户不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		UserMessage userMessage = umDao.findByExample(um).get(0);
		em.setUid(userMessage.getId());
		imDao.save(em);
		try {
			ResponseUtils.write(response, "添加成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/submitExternalMessage")
	public void submitExternalMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, ExternalMessage em){
		UserMessage um = new UserMessage();
		um.setCardNo(cardNo);
		try {
			if(umDao.findByExample(um).isEmpty()){
				ResponseUtils.write(response, "用户不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		UserMessage userMessage = umDao.findByExample(um).get(0);
		em.setUid(userMessage.getId());
		exmDao.save(em);
		try {
			ResponseUtils.write(response, "添加成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/submitEarMessage")
	public void submitEarMessage(HttpServletRequest request,
			HttpServletResponse response, String cardNo, EarMessage em){
		UserMessage um = new UserMessage();
		um.setCardNo(cardNo);
		try {
			if(umDao.findByExample(um).isEmpty()){
				ResponseUtils.write(response, "用户不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		UserMessage userMessage = umDao.findByExample(um).get(0);
		em.setUid(userMessage.getId());
		earDao.save(em);
		try {
			ResponseUtils.write(response, "添加成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/addBloodMessageDemo")
	public ModelAndView addBloodMessageDemo(HttpServletRequest request,
			HttpServletResponse response, String cardNo){
		request.getSession().setAttribute("cardNo", cardNo);
		return new ModelAndView("healthy/addBloodMessage");
	}
	@RequestMapping(value = "/addLiverMessageDemo")
	public ModelAndView addLiverMessageDemo(HttpServletRequest request,
			HttpServletResponse response, String cardNo){
		request.getSession().setAttribute("cardNo", cardNo);
		return new ModelAndView("healthy/addLiverMessage");
	}
	@RequestMapping(value = "/createHealthyExam")
	public ModelAndView createHealthyExam(HttpServletRequest request,
			HttpServletResponse response, BodyDetails bd){
		UserMessage um = (UserMessage)request.getSession().getAttribute("user");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try{
			EyeMessage em = new EyeMessage();
			InternalMessage im = new InternalMessage();
			EarMessage eam = new EarMessage();
			BloodMessage bm = new BloodMessage();
			ChestRay cr = new ChestRay();
			ExternalMessage exm = new ExternalMessage();
			em.setColorSense(bd.getColorSense());
			em.setDate(date);
			em.setEyeInspector(bd.getEyeInspector());
			em.setLeftEye(bd.getLeftEye());
			em.setRightEye(bd.getRightEye());
			em.setUid(um.getId());
			emDao.save(em);
			im.setBloodPressure(bd.getBloodPressure());
			im.setDate(date);
			im.setHeartAndLung(bd.getHeartAndLung());
			im.setInternalInspector(bd.getInternalInspector());
			im.setUid(um.getId());
			imDao.save(im);
			eam.setDate(date);
			eam.setEarInspector(bd.getEarInspector());
			eam.setLeftEar(bd.getLeftEar());
			eam.setRightEar(bd.getRightEar());
			eam.setUid(um.getId());
			earDao.save(eam);
			bm.setBlood(bd.getBlood());
			bm.setBloodInspector(bd.getBloodInspector());
			bm.setDate(date);
			bm.setUid(um.getId());
			bmDao.save(bm);
			cr.setChestInspector(bd.getChestInspector());
			cr.setChestX(bd.getChestX());
			cr.setDate(date);
			cr.setUid(um.getId());
			crDao.save(cr);
			exm.setDate(date);
			exm.setExternalInspector(bd.getExternalInspector());
			exm.setExtremitiesAndSpine(bd.getExtremitiesAndSpine());
			exm.setHeight(bd.getHeight());
			exm.setOthers(bd.getOthers());
			exm.setSkin(bd.getSkin());
			exm.setUid(um.getId());
			exm.setWeight(bd.getWeight());
			exmDao.save(exm);
			return new ModelAndView("healthy/healthyExam");
		}catch(Exception e){
			return new ModelAndView("");
		}
	}
	@RequestMapping(value = "/createEyeMessage")
	public ModelAndView createEyeMessage(){
		return new ModelAndView("healthy/createEyeMessage");
	}
	@RequestMapping(value = "/createInternalMessage")
	public ModelAndView createInternalMessage(){
		return new ModelAndView("healthy/createInternalMessage");
	}
	@RequestMapping(value = "/createExternalMessage")
	public ModelAndView createExternalMessage(){
		return new ModelAndView("healthy/createExternalMessage");
	}
	@RequestMapping(value = "/createEarMessage")
	public ModelAndView createEarMessage(){
		return new ModelAndView("healthy/createEarMessage");
	}
	@RequestMapping(value = "/createBloodMessage")
	public ModelAndView createBloodMessage(){
		return new ModelAndView("healthy/createBloodMessage");
	}
	@RequestMapping(value = "/createChest")
	public ModelAndView createChest(){
		return new ModelAndView("healthy/createChest");
	}
	@RequestMapping(value = "/createBMessage")
	public ModelAndView createBMessage(){
		return new ModelAndView("healthy/createBMessage");
	}
	@RequestMapping(value = "/createLiverMessage")
	public ModelAndView createLiverMessage(){
		return new ModelAndView("healthy/createLiverMessage");
	}
	@RequestMapping(value = "/updateEyeMessageDemo")
	public ModelAndView updateEyeMessageDemo(HttpServletRequest request,
			HttpServletResponse response, EyeMessage em){
		EyeMessage eyeMessage = (EyeMessage) emDao.findById(em).get(0);
		request.getSession().setAttribute("eyeMessage", eyeMessage);
		return new ModelAndView("/healthy/updateEyeMessage");
	}
	@RequestMapping(value = "/changeEyeMessage")
	public void changeEyeMessage(HttpServletRequest request,
			HttpServletResponse response, EyeMessage em){
		EyeMessage eyeMessage = emDao.findById(em.getId(), EyeMessage.class.getName());
		eyeMessage.setLeftEye(em.getLeftEye());
		eyeMessage.setRightEye(em.getRightEye());
		eyeMessage.setColorSense(em.getColorSense());
		eyeMessage.setComment(em.getComment());
		eyeMessage.setDate(em.getDate());
		emDao.attachDirty(eyeMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateInternalMessageDemo")
	public ModelAndView updateInternalMessageDemo(HttpServletRequest request,
			HttpServletResponse response, InternalMessage im){
		InternalMessage internalMessage = (InternalMessage) imDao.findById(im).get(0);
		request.getSession().setAttribute("internalMessage", internalMessage);
		return new ModelAndView("/healthy/updateInternalMessage");
	}
	@RequestMapping(value = "/changeInternalMessage")
	public void changeInternalMessage(HttpServletRequest request,
			HttpServletResponse response, InternalMessage im){
		InternalMessage internalMessage = imDao.findById(im.getId(), InternalMessage.class.getName());
		internalMessage.setBloodPressure(im.getBloodPressure());
		internalMessage.setHeartAndLung(im.getHeartAndLung());;
		internalMessage.setComment(im.getComment());
		internalMessage.setDate(im.getDate());
		imDao.attachDirty(internalMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/updateExternalMessageDemo")
	public ModelAndView updateExternalMessageDemo(HttpServletRequest request,
			HttpServletResponse response, ExternalMessage em){
		ExternalMessage externalMessage = (ExternalMessage) exmDao.findById(em).get(0);
		request.getSession().setAttribute("externalMessage", externalMessage);
		return new ModelAndView("/healthy/updateExternalMessage");
	}
	@RequestMapping(value = "/changeExternalMessage")
	public void changeInternalMessage(HttpServletRequest request,
			HttpServletResponse response, ExternalMessage em){
		ExternalMessage externalMessage = exmDao.findById(em.getId(), ExternalMessage.class.getName());
		externalMessage.setHeight(em.getHeight());
		externalMessage.setWeight(em.getWeight());
		externalMessage.setSkin(em.getSkin());
		externalMessage.setExtremitiesAndSpine(em.getExtremitiesAndSpine());
		externalMessage.setOthers(em.getOthers());
		externalMessage.setComment(em.getComment());
		externalMessage.setDate(em.getDate());
		exmDao.attachDirty(externalMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/updateEarMessageDemo")
	public ModelAndView updateEarMessageDemo(HttpServletRequest request,
			HttpServletResponse response, EarMessage em){
		EarMessage earMessage = (EarMessage) earDao.findById(em).get(0);
		request.getSession().setAttribute("earMessage", earMessage);
		return new ModelAndView("/healthy/updateEarMessage");
	}
	@RequestMapping(value = "/changeEarMessage")
	public void changeEarMessage(HttpServletRequest request,
			HttpServletResponse response, EarMessage em){
		EarMessage earMessage = earDao.findById(em.getId(), EarMessage.class.getName());
		earMessage.setLeftEar(em.getLeftEar());
		earMessage.setRightEar(em.getRightEar());
		earMessage.setComment(em.getComment());
		earDao.attachDirty(earMessage);
		earMessage.setDate(em.getDate());
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/updateBloodMessageDemo")
	public ModelAndView updateBloodMessageDemo(HttpServletRequest request,
			HttpServletResponse response, BloodMessage bm){
		BloodMessage bloodMessage = (BloodMessage) bmDao.findById(bm).get(0);
		request.getSession().setAttribute("bloodMessage", bloodMessage);
		return new ModelAndView("/healthy/updateBloodMessage");
	}
	@RequestMapping(value = "/changeBloodMessage")
	public void changeBloodMessage(HttpServletRequest request,
			HttpServletResponse response, BloodMessage bm){
		BloodMessage bloodMessage = bmDao.findById(bm.getId(), BloodMessage.class.getName());
		bloodMessage.setBloodInspector(bm.getBloodInspector());
		bloodMessage.setComment(bm.getComment());
		bloodMessage.setDate(bm.getDate());
		earDao.attachDirty(bloodMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/updateLiverMessageDemo")
	public ModelAndView updateLiverMessageDemo(HttpServletRequest request,
			HttpServletResponse response, LiverMessage lm){
		LiverMessage liverMessage = (LiverMessage) lmDao.findById(lm).get(0);
		request.getSession().setAttribute("liverMessage", liverMessage);
		return new ModelAndView("/healthy/updateLiverMessage");
	}
	@RequestMapping(value = "/changeLiverMessage")
	public void changeLiverMessage(HttpServletRequest request,
			HttpServletResponse response, LiverMessage lm){
		LiverMessage liverMessage = lmDao.findById(lm.getId(), LiverMessage.class.getName());
		liverMessage.setLiverInspector(lm.getLiverInspector());
		liverMessage.setComment(lm.getComment());
		liverMessage.setDate(lm.getDate());
		earDao.attachDirty(liverMessage);
		try {
			ResponseUtils.write(response, "修改成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private EyeMessage getEyeMessage(Integer uid, Integer bdId){
		EyeMessage em = new EyeMessage();
		em.setUid(uid);
		em.setId(bdId);
		List<EyeMessage> ems = emDao.findByUidAndId(em);
		if(ems.isEmpty()){
			return null;
		}
		return ems.get(0);
	}
	
	private List<EyeMessage> getEyeMessages(Integer uid){
		EyeMessage em = new EyeMessage();
		em.setUid(uid);
		List<EyeMessage> ems = emDao.findByExample(em);
		if(ems.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return ems;
	}
	
	private InternalMessage getInternalMessage(Integer uid, Integer bdId){
		InternalMessage im = new InternalMessage();
		im.setUid(uid);
		im.setId(bdId);
		List<InternalMessage> ims = imDao.findByUidAndId(im);
		if(ims.isEmpty()){
			return null;
		}
		return ims.get(0);
	}
	
	private List<InternalMessage> getInternalMessage(Integer uid){
		InternalMessage im = new InternalMessage();
		im.setUid(uid);
		List<InternalMessage> ims = imDao.findByUid(im);
		if(ims.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return ims;
	}
	private ExternalMessage getExternalMessage(Integer uid,Integer bdId){
		ExternalMessage exm = new ExternalMessage();
		exm.setUid(uid);
		exm.setId(bdId);
		List<ExternalMessage> exms = exmDao.findByUidAndId(exm);
		return exms.get(0);
	}
	private List<ExternalMessage> getExternalMessage(Integer uid){
		ExternalMessage exm = new ExternalMessage();
		exm.setUid(uid);
		List<ExternalMessage> exms = exmDao.findByUid(exm);
		return exms;
	}
	
	private EarMessage getEarMessage(Integer uid, Integer bdId){
		EarMessage eam = new EarMessage();
		eam.setUid(uid);
		eam.setId(bdId);
		List<EarMessage> eams = earDao.findByUidAndId(eam);
		if(eams.isEmpty()){
			return null;
		}
		return eams.get(0);
	}
	private List<EarMessage> getEarMessages(Integer uid){
		EarMessage eam = new EarMessage();
		eam.setUid(uid);
		List<EarMessage> eams = earDao.findByUid(eam);
		if(eams.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return eams;
	}
	
	private BloodMessage getBloodMessage(Integer uid, Integer bdId){
		BloodMessage bm = new BloodMessage();
		bm.setUid(uid);
		bm.setId(bdId);
		List<BloodMessage> bms = bmDao.findByUid(bm);
		if(bms.isEmpty()){
			return null;
		}
		return bms.get(0);
	}
	private List<BloodMessage> getBloodMessages(Integer uid){
		BloodMessage bm = new BloodMessage();
		bm.setUid(uid);
		List<BloodMessage> bms = bmDao.findByUid(bm);
		if(bms.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return bms;
	}
	
	private ChestRay getChestRay(Integer uid, Integer bdId){
		ChestRay cr = new ChestRay();
		cr.setUid(uid);
		cr.setId(bdId);
		List<ChestRay> crs = crDao.findByUidAndId(cr);
		if(crs.isEmpty()){
			return null;
		}
		return crs.get(0);
	}
	private List<ChestRay> getChestRay(Integer uid){
		ChestRay cr = new ChestRay();
		cr.setUid(uid);
		List<ChestRay> crs = crDao.findByUidAndId(cr);
		if(crs.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return crs;
	}
	
	private List<BMessage> getBMessages(Integer uid){
		BMessage bMessage = new BMessage();
		bMessage.setUid(uid);
		List<BMessage> bMessages = bMessageDao.findByUid(bMessage);
		if(bMessages.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return bMessages;
	}
	private List<LiverMessage> getLiverMessages(Integer uid){
		LiverMessage lm = new LiverMessage();
		lm.setUid(uid);
		List<LiverMessage> lms = lmDao.findByUid(lm);
		if(lms.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return lms;
	}
}
