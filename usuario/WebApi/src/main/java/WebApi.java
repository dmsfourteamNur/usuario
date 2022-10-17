import Controllers.UsuarioController;
import Fourteam.http.Rest;

public class WebApi {

	public static void AddControllers() {
		Rest.addController(UsuarioController.class);
		Rest.start(Integer.parseInt(Fourteam.config.Config.getProperty("http.port")));
		Rest.createSwagger();
		// openApi();
	}

	// public static void openApi() {
	// if (java.awt.Desktop.isDesktopSupported()) {
	// java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
	// if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
	// try {
	// java.net.URI uri = new java.net.URI(
	// "http://localhost:" + Integer.parseInt(Config.getProperty("http.port")) +
	// "/swagger.html");
	// java.net.URI uri1 = new java.net.URI(
	// "http://localhost:" + Integer.parseInt(Config.getProperty("http.port")) +
	// "/api/vuelo");
	// java.net.URI uri2 = new java.net.URI(
	// "http://localhost:" + Integer.parseInt(Config.getProperty("http.port")) +
	// "/api/aeronave");
	// java.net.URI uri3 = new java.net.URI(
	// "http://localhost:" + Integer.parseInt(Config.getProperty("http.port")) +
	// "/api/tripulacion");
	// desktop.browse(uri);
	// desktop.browse(uri1);
	// desktop.browse(uri2);
	// desktop.browse(uri3);
	// } catch (URISyntaxException | IOException ex) {
	// }
	// }
	// }
	// }

}
