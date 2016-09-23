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
@Table(name = "emotion_message")
public class EmotionMessage extends BaseEntity {
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
	public EmotionMessage(Integer id) {
		this.id = id;
	}
	public EmotionMessage() {
	}
	@Column(name = "uid")
	private int uid;
	@Column(name = "happy_times")
	private int happyTimes;
	@Column(name = "happy_level")
	private String happyLevel;
	@Column(name = "happy_behaviour")
	private String happyBehaviour;
	@Column(name = "angry_times")
	private int angryTimes;
	@Column(name = "angry_level")
	private String angryLevel;
	@Column(name = "angry_behaviour")
	private String angryBehaviour;
	@Column(name = "sad_times")
	private int sadTimes;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getHappyTimes() {
		return happyTimes;
	}
	public void setHappyTimes(int happyTimes) {
		this.happyTimes = happyTimes;
	}
	public String getHappyLevel() {
		return happyLevel;
	}
	public void setHappyLevel(String happyLevel) {
		this.happyLevel = happyLevel;
	}
	public String getHappyBehaviour() {
		return happyBehaviour;
	}
	public void setHappyBehaviour(String happyBehaviour) {
		this.happyBehaviour = happyBehaviour;
	}
	public int getAngryTimes() {
		return angryTimes;
	}
	public void setAngryTimes(int angryTimes) {
		this.angryTimes = angryTimes;
	}
	public String getAngryLevel() {
		return angryLevel;
	}
	public void setAngryLevel(String angryLevel) {
		this.angryLevel = angryLevel;
	}
	public String getAngryBehaviour() {
		return angryBehaviour;
	}
	public void setAngryBehaviour(String angryBehaviour) {
		this.angryBehaviour = angryBehaviour;
	}
	public int getSadTimes() {
		return sadTimes;
	}
	public void setSadTimes(int sadTimes) {
		this.sadTimes = sadTimes;
	}
}
