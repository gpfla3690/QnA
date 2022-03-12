package qna.app.components;

import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;

public interface Controller extends Component {
	
	public void getMapping(AppRequest appReq, UriProcessor uriProcessor);
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor);

}
