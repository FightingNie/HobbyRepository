package healthyhome.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "hospitalization_records")
public class HospitalizationRecords extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//GenerationType.IDENTITY
	@Column(name = "id")
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public HospitalizationRecords(Integer id) {
		this.id = id;
	}
	public HospitalizationRecords() {
	}
	@Column(name = "uid")
	private int uid;
	@Column(name="date")
	private String date;
	@Column(name = "disease")
	private String disease;
	@Column(name = "level")
	private String level;
	@Column(name = "hospitol_address")
	private String hospitolAddress;
	@Column(name = "hospitalized_times")
	private int hospitalizedTimes;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getHospitolAddress() {
		return hospitolAddress;
	}
	public void setHospitolAddress(String hospitolAddress) {
		this.hospitolAddress = hospitolAddress;
	}
	public int getHospitalizedTimes() {
		return hospitalizedTimes;
	}
	public void setHospitalizedTimes(int hospitalizedTimes) {
		this.hospitalizedTimes = hospitalizedTimes;
	}
}
