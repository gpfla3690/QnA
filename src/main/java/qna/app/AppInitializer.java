package qna.app;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import qna.app.container.AppContainer;

@WebListener
public class AppInitializer implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		AppContainer.componentAssemble();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	

}
