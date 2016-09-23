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
@Table(name = "eye_message")
public class EyeMessage extends BaseEntity{
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
	
	public EyeMessage() {
	}
	
	public EyeMessage(Integer id) {
		this.id = id;
	}
	
	@Column(name = "uid")
	private int uid;
	@Column(name = "left_eye")
	private String leftEye;
	@Column(name = "right_eye")
	private String rightEye;
	@Column(name = "color_sense")
	private String colorSense;
	@Column(name = "eye_inspector")
	private String eyeInspector;
	@Column(name="date")
	private String date;
	@Column(name = "comment")
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLeftEye() {
		return leftEye;
	}
	public void setLeftEye(String leftEye) {
		this.leftEye = leftEye;
	}
	public String getRightEye() {
		return rightEye;
	}
	public void setRightEye(String rightEye) {
		this.rightEye = rightEye;
	}
	public String getColorSense() {
		return colorSense;
	}
	public void setColorSense(String colorSense) {
		this.colorSense = colorSense;
	}
	public String getEyeInspector() {
		return eyeInspector;
	}
	public void setEyeInspector(String eyeInspector) {
		this.eyeInspector = eyeInspector;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
