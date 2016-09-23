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
@Table(name = "chest_ray")
public class ChestRay extends BaseEntity{
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
	public ChestRay() {
	}
	public ChestRay(Integer id) {
		this.id = id;
	}
	@Column(name="date")
	private String date;
	@Column(name = "uid")
	private int uid;
	@Column(name = "chest_x")
	private String chestX;
	@Column(name = "chest_inspector")
	private String chestInspector;
	@Column(name = "comment")
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getChestX() {
		return chestX;
	}
	public void setChestX(String chestX) {
		this.chestX = chestX;
	}
	public String getChestInspector() {
		return chestInspector;
	}
	public void setChestInspector(String chestInspector) {
		this.chestInspector = chestInspector;
	}
}
