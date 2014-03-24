
import java.io.File;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class CanyinWWWStart {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		File rootDir = new File(CanyinWWWStart.class.getResource("/").getPath()).getParentFile().getParentFile();

		String webAppPath = new File(rootDir, "src/main/webapp").getPath();
		new WebAppContext(server, webAppPath, "/");
		server.start();
	}
}