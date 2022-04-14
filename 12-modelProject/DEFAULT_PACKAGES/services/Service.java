@Service
public class OBJECTService {
		
	@Autowired
	private OBJECTRepository repository;
	
	// create
    public OBJECT create(OBJECT newOBJECT) {
    	return repository.save(newOBJECT);
    }
    
    // read
    public OBJECT read(Long id) {
        Optional<OBJECT> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<OBJECT> readAll() {
        return repository.findAll();
    }
    // update
    public OBJECT update(OBJECT o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<OBJECT> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}