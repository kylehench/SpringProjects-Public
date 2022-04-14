@Entity
@Table(name="OBJECTS")
public class Answer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty
	String NAME;
    
 	@Column(updatable=false)
 	@DateTimeFormat(pattern="yyyy-MM-dd")
 	private Date createdAt;
 	
 	@DateTimeFormat(pattern="yyyy-MM-dd")
 	private Date updatedAt;
 	
 	// generate empty constructor for Spring Boot
 	
 	// generate getters and setters

	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
}