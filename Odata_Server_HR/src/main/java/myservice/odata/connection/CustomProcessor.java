package myservice.odata.connection;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderReadProperties;
import org.apache.olingo.odata2.api.ep.entry.ODataEntry;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PostUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.core.ODataJPAProcessorDefault;

 
public class CustomProcessor extends ODataJPAProcessorDefault {
	
	public CustomProcessor(ODataJPAContext oDataJPAContext) {
		super(oDataJPAContext);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ODataResponse readEntitySet(final GetEntitySetUriInfo uriParserResultView, final String contentType)
			throws ODataException {
		return ODataResponse.fromResponse(super.readEntitySet(uriParserResultView, contentType))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public ODataResponse readEntity(final GetEntityUriInfo uriInfo, final String contentType) throws ODataException {

		return ODataResponse.fromResponse(super.readEntity(uriInfo, contentType))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public ODataResponse updateEntity(final PutMergePatchUriInfo uriParserResultView, final InputStream content,
			final String requestContentType, final boolean merge, final String contentType) throws ODataException {
		return ODataResponse
				.fromResponse(super.updateEntity(uriParserResultView, content, requestContentType, merge, contentType))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public ODataResponse deleteEntity(final DeleteUriInfo uriParserResultView, final String contentType)
			throws ODataException {
		return ODataResponse.fromResponse(super.deleteEntity(uriParserResultView, contentType))
				.header("Access-Control-Allow-Origin", "*").build();
	}
	@Override
	public ODataResponse createEntity(PostUriInfo uriInfo, InputStream content, String requestContentType,
			String contentType) throws ODataException {
/*		EntityProviderReadProperties properties = EntityProviderReadProperties.init().mergeSemantic(false).build();
		EdmEntitySet ee = uriInfo.getTargetEntitySet();
		  ODataEntry entry = EntityProvider.readEntry(requestContentType, uriInfo.getTargetEntitySet(), content, properties);
		  //if something goes wrong in deserialization this is managed via the ExceptionMapper,
		  //no need for an application to do exception handling here an convert the exceptions in HTTP exceptions

		  Map<String, Object> data = entry.getProperties();*/
		return super.createEntity(uriInfo, content, requestContentType, contentType);
				
	}

}
