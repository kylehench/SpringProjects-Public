@Repository
public interface OBJECTRepository extends CrudRepository<OBJECT, Long>{
		
	// retrieve all the OBJECTS from the database
	List<OBJECT> findAll();
  
    // retrieves one OBJECT from the database by ID
    Optional<OBJECT> findById(long id);
  
    // retrieve OBJECTS that have null ATTRIBUTE
    List<OBJECT> ATTRIBUTEIsNull();
  
  	// retrieves one OBJECT from the database
    Optional<OBJECT> findByUNIQUE_ATTRIBUTE(String string);
  
    // Retrieves a list of any OBJECTS a particular OBJECT_TYPE_2
    // does not belong to.
    List<OBJECTS> findByOBJECT_TYPE_2SNotContains(OBJECT_TYPE_2 OBJECT_TYPE_2_VAR);
}