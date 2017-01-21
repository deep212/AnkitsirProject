package com.project.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;

public final class TilesDefinitionsConfig implements DefinitionsFactory {
	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute BASE_TEMPLATE = new Attribute(
			"/WEB-INF/layout/defaultLayout.jsp");

	// private static final org.apache.tiles.Attribute BASE_TEMPLATE = new
	// org.apache.tiles.Attribute("/WEB-INF/layout/defaultLayout.jsp");
	public Definition getDefinition(String name,
			org.apache.tiles.request.Request tilesContext) {
		return tilesDefinitions.get(name);
	}

	/**
	 * @param name
	 *            <code>Name of the view</code>
	 * @param title
	 *            <code>Page title</code>
	 * @param body
	 *            <code>Body JSP file path</code>
	 *
	 *            <code>Adds default layout definitions</code>
	 */
	private static void addDefaultLayoutDef(String name, String title,
			String body, String header) {
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("title", new Attribute(title));
		attributes.put("header", new Attribute(header));
		attributes.put("body", new Attribute(body));
		attributes.put("footer", new Attribute("/WEB-INF/layout/footer.jsp"));
		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE,
				attributes));
	}

	public static void addDefinitions() {
		addDefaultLayoutDef("home", "HomePage", "/WEB-INF/jsp/home.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("registration", "RegistrationPage", "/WEB-INF/jsp/registration.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("userlogin", "login", "/WEB-INF/jsp/login.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("userhome", "user", "/WEB-INF/jsp/UserHome.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("updatedata", "update", "/WEB-INF/jsp/update.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("forget12", "forget", "/WEB-INF/jsp/Forget.jsp","/WEB-INF/layout/header.jsp");
		addDefaultLayoutDef("changepassword", "password", "/WEB-INF/jsp/ChangePaasword.jsp","/WEB-INF/layout/header.jsp");
	}

}
