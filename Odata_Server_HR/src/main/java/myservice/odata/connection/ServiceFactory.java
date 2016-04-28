package myservice.odata.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class ServiceFactory extends ODataJPAServiceFactory{
	private static final String PERSISTENCE_UNIT_NAME = "Odata_Server_V1";
	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		// TODO Auto-generated method stub
		ODataJPAContext oDataJPAContext = this.getODataJPAContext();  
        try {  
        	
            EntityManagerFactory emf = Persistence  
                    .createEntityManagerFactory(PERSISTENCE_UNIT_NAME);  
            oDataJPAContext.setEntityManagerFactory(emf);  
            oDataJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);  
            return oDataJPAContext;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
	}

	@Override
	public ODataService createODataSingleProcessorService(EdmProvider provider, ODataSingleProcessor processor) {
		// TODO Auto-generated method stub
		
		return super.createODataSingleProcessorService(provider, processor);
	}

}
