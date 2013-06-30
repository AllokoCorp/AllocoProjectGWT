package com.project.Alloco.shared;


public class Enumerations {


	// MySQL information
	public final static String  DB_URL                      = "jdbc:mysql://127.0.0.1:3306/Alloco";
	public final static String  DB_USERNAME                 = "alloco";
	public final static String  DB_PASSWORD                 = "alloco";
	public final static String  DB_DRIVER                   = "com.mysql.jdbc.Driver";

	// MySQL Statements
	public final static String  SQL_GET_ALL_HOUSE           = "SELECT * FROM alloco.house;";




	public static enum Language {
		FRENCH("fr"), ENGLISH("en");
		private String locale;

		Language(String locale) {
			this.locale = locale;
		}

		public String toString() {
			return this.locale;
		}
	}



	public static enum CookieAttribute {
		ALLOCOUSER
	}

	public static enum AllocoPages {
		LOGIN, INSCRIPTIONVIEW, DEFAULTVIEW, BASEVIEW
	}

	public static enum ConfigKey {
		// database info
		DB_USERNAME("DB_username"), DB_PASSWORD("DB_password"), DB_URL("DB_url"), 
		DB_DRIVER("DB_driver"), 
		// general
		MAX_FAVORITES("SYS_maxfavorites"), MIN_UPDATE_TIME("SYS_minUpdateTime"), 
		MAX_UPDATE_TIME("SYS_maxUpdateTime"), SCHEDULED_TASK_MANAGER_WAIT_TIME("SYS_scheduledTaskManagerWaitTime"), 
		ADMIN_EMAIL("SYS_adminEmail"), 
		// default domain names for virtual machines
		DEFAULT_DOMAIN("DEFAULT_DOMAIN"),

		// Groups
		SEARCH_GROUP_BY_GROUP_CN_ASG("G_Payment"), SEARCH_GROUP_BY_GROUP_CN_TPM("G_Plexus"), 
		// AD info
		AD_REALM("AD_realm"), AD_KDC("AD_kdc");

		private String keyName;

		private ConfigKey(String keyName) {
			this.keyName = keyName;
		}

		public String toString() {
			return this.keyName;
		}
	}

	public static enum ErrorMessages {
		ERR_NO_VM_WITH_THIS_NAME(
				"There are no virtual machine on this server with the name :"), ERR_WAITING_ON_TASK(
						"Access denied, contact the administrator."), ERR_INVALID_CONFIG_VALUE(
								"Config value read was invalid.");

		private String message;

		private ErrorMessages(String message) {
			this.message = message;
		}

		public String toString() {
			return this.message;
		}
	}


	public static enum UserGroups {
		NONE, ADMINISTRATEUR, USAGER, BOTH
	}

}
