package com.project.Alloco.server;
import java.util.List;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.Alloco.client.service.AllocoControllerService;
import com.project.Alloco.shared.model.allocoUser;

public class AllocoControllerServiceImpl extends RemoteServiceServlet implements AllocoControllerService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public IController ctrl;
	//private ListUpdaterPushingServer server = new ListUpdaterPushingServer();
	//private LogUpdaterPushingServer log = new LogUpdaterPushingServer();
	

	public void init() {
		//try {
			//ctrl = new AllocoController();
		//} catch (OperationException e) {
			//logger.fatal("OperationException catch in VlpControllerServiceImpl.init",e);
		//}
		//ctrl.setObserver(server);
		//ctrl.setObserver(log);
		//ctrl.setPushingServer(server);
	}

	public void destroy()
	{
		//logger.info("VlpControllerServlet: destroy.  Bye-bye.");
	}

	@Override
	public allocoUser getAllocoUser(String username, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllocoUserMembre(String username, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}

