package healthyhome.action.healthyaction;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import healthyhome.bean.FamilyIllness;
import healthyhome.bean.HospitalizationRecords;
import healthyhome.bean.SeriousIllness;
import healthyhome.bean.UserMessage;
import healthyhome.dao.FamilyIllnessDao;
import healthyhome.dao.HospitalizationRecordsDao;
import healthyhome.dao.SeriousIllnessDao;
import healthyhome.util.ResponseUtils;

@Controller
public class IllnessRecordsController {

	@Autowired
	private SeriousIllnessDao siDao;
	@Autowired
	private HospitalizationRecordsDao hrDao;
	@Autowired
	private FamilyIllnessDao fiDao;
	
	@RequestMapping(value = "/illnessRecords")
	public ModelAndView getIllnessRecords(HttpServletRequest request){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<SeriousIllness> sis = getSeriousIllness(uid);
		List<HospitalizationRecords> hrs = getHospitalizationRecords(uid);
		List<FamilyIllness> fis = getFamilyIllness(uid);
		if(sis.isEmpty()){
			request.getSession().setAttribute("smessage", "暂无记录");
		}else{
			request.getSession().setAttribute("sis", sis);
			request.getSession().setAttribute("smessage", null);
		}
	
		if(hrs.isEmpty()){
			request.getSession().setAttribute("hmessage", "暂无记录");
		}else{
			request.getSession().setAttribute("hrs", hrs);
			request.getSession().setAttribute("hmessage", null);
		}
		
		if(fis.isEmpty()){
			request.getSession().setAttribute("fmessage", "暂无记录");
		}else{
			request.getSession().setAttribute("fis", fis);
			request.getSession().setAttribute("fmessage", null);
		}
		
		return new ModelAndView("healthy/showIllnessRecords");
	}
	@RequestMapping(value = "/addSeriousIllnessDemo")
	public ModelAndView addSeriousIllnessDemo(){
		return new ModelAndView("illnessrecord/addSeriousIllness");
	}
	
	@RequestMapping(value = "/addHospitalizationRecordsDemo")
	public ModelAndView addHospitalizationRecordsDemo(){
		return new ModelAndView("illnessrecord/addHospitalizationRecords");
	}
	@RequestMapping(value = "/addFamilyIllnessDemo")
	public ModelAndView addFamilyIllnessDemo(){
		return new ModelAndView("illnessrecord/addFamilyIllness");
	}
	@RequestMapping(value = "/addSeriousIllness")
	public void addSeriousIllness(HttpServletRequest request, HttpServletResponse response, SeriousIllness si){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<SeriousIllness> sis = getSeriousIllness(uid);
		int times = sis.size()+1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try{
			SeriousIllness s = new SeriousIllness();
			s.setDate(date);
			s.setDisease(si.getDisease());
			s.setHospitalizedTimes(times);
			s.setHospitolAddress(si.getHospitolAddress());
			s.setLevel(si.getLevel());
			s.setUid(uid);
			siDao.save(s);
			ResponseUtils.write(response, "添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/addHospitalizationRecords")
	public void addHospitalizationRecords(HttpServletRequest request, HttpServletResponse response, HospitalizationRecords hr){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		List<HospitalizationRecords> sis = getHospitalizationRecords(uid);
		int times = sis.size()+1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		try{
			HospitalizationRecords h = new HospitalizationRecords();
			h.setDate(date);
			h.setDisease(hr.getDisease());
			h.setHospitalizedTimes(times);
			h.setHospitolAddress(hr.getHospitolAddress());
			h.setLevel(hr.getLevel());
			h.setUid(uid);
			hrDao.save(h);
			ResponseUtils.write(response, "添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/addFamilyIllness")
	public void addFamilyIllness(HttpServletRequest request, HttpServletResponse response, FamilyIllness fi){
		UserMessage um = (UserMessage) request.getSession()
				.getAttribute("user");
		int uid = um.getId();
		try{
			FamilyIllness f = new FamilyIllness();
			f.setAlive(fi.getAlive());
			f.setDisease(fi.getDisease());
			f.setRelationship(fi.getRelationship());
			f.setUid(uid);
			fiDao.save(f);
			ResponseUtils.write(response, "添加成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private List<SeriousIllness> getSeriousIllness(int uid){
		SeriousIllness si = new SeriousIllness();
		si.setUid(uid);
		List<SeriousIllness> sis = siDao.findByUid(si);
		if(sis.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return sis;
	}
	
	private List<HospitalizationRecords> getHospitalizationRecords(int uid){
		HospitalizationRecords hr = new HospitalizationRecords();
		hr.setUid(uid);
		List<HospitalizationRecords> hrs = hrDao.findByUid(hr);
		if(hrs.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return hrs;
	}
	
	private List<FamilyIllness> getFamilyIllness(int uid){
		FamilyIllness fi = new FamilyIllness();
		fi.setUid(uid);
		List<FamilyIllness> fis = fiDao.findByExample(fi);
		if(fis.isEmpty()){
			return Collections.EMPTY_LIST;
		}
		return fis;
	}
}
