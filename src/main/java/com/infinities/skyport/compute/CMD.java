package com.infinities.skyport.compute;

import java.io.Serializable;

import com.google.common.collect.ImmutableMap;

public class CMD implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final ImmutableMap<Integer, String> cmdTable;

	public static final int CREATE_VM = 0x00000001;
	public static final int START_VM = 0x00000002;
	public static final int STOP_VM = 0x00000003;
	public static final int LIST_VM = 0x00000004;
	public static final int CLONE_VM = 0x00000005;
	public static final int UPDATE_VM = 0x00000006; // Modify Vm data and
													// setting attributes
	public static final int REMOVE_VM = 0x00000007;
	public static final int MIGRATE_VM = 0x00000009;
	public static final int SEARCH_VM = 0x0000000A;

	public static final int CREATE_VNC_CHANNEL = 0x08;

	public static final int THIN_PROVISION = 0x0B;

	public static final int BACKUP_VM = 0x0000000C; // Snapshot
	public static final int RESTORE_SNAPSHOT = 0x0000000D;
	public static final int EXPORT_VM = 0x0000000E;
	public static final int RESTART_VM = 0x0000000F;

	// Template Command
	public static final int SEARCH_TEMPLATE = 0x10000001;
	public static final int ADD_TEMPLATE = 0x10000002;
	public static final int REMOVE_TEMPLATE = 0x10000003;
	public static final int EXPORT_TEMPLATE = 0x10000004;
	public static final int LIST_TEMPLATE = 0x10000011;

	// Snapshot
	public static final int LIST_SNAPSHOT = 0x20000001;

	// HOST command
	public static final int SEARCH_HOST = 0x30000001;
	public static final int GET_HOST = 0x30000002;

	// Status command
	public static final int GET_ALL_RUNNING_VM_STATUS = 0x40000001;
	public static final int GET_RUNNING_VM_STATUS = 0x40000002;
	public static final int GET_HOST_STATUS = 0x40000003;

	// Disk command
	// public final static int NEW_DISK = 0x50000001;
	public static final int ADD_DISK = 0x50000002;
	public static final int REMOVE_DISK = 0x50000003;
	public static final int LIST_DISK = 0x50000004;
	public static final int CREATE_DISK = 0x50000005;
	public static final int ATTACH_DISK = 0x50000006;
	public static final int DETACH_DISK = 0x50000007;
	public static final int DELETE_DISK = 0x50000008;

	// Network command
	public static final int GET_NETWORKS = 0x60000001;
	public static final int ADD_NETWORK_ADAPTER = 0x60000002;
	public static final int REMOVE_NETWORK_ADAPTER = 0x60000003;
	public static final int GET_NETWORK_ADAPTERS = 0x60000004;

	// Import command
	public static final int LIST_EXPORTED_VM = 0x70000001;
	public static final int LIST_EXPORTED_TEMPLATE = 0x70000002;
	public static final int REMOVE_EXPORTED_VM = 0x70000003;
	public static final int REMOVE_EXPORTED_TEMPLATE = 0x70000004;
	public static final int IMPORT_EXPORTED_VM = 0x70000005;
	public static final int IMPORT_EXPORTED_TEMPLATE = 0x70000006;

	// Storage command
	public static final int LIST_DATACENTER = 0x11000001;
	public static final int LIST_STORAGE = 0x11000002;
	public static final int LIST_CLUSTER = 0x11000003;
	public static final int LIST_RESOURCE = 0x11000004;

	// DHCP command
	public static final int BIND_IP = 0x12000001;
	public static final int UNBIND_IP = 0x12000002;
	public static final int UNBIND_IP_BY_MAC = 0x12000003;
	public static final int UNBIND_IP_BY_VMID = 0x12000004;

	public static final int TEST = 0x10010001;

	// Skyport command
	public static final int GET_SYSTEMINFO = 0x13000000;
	public static final int LIST_POOL = 0x13000001;
	public static final int GET_POOL = 0x13000002;
	public static final int LIST_API = 0x13000003;
	public static final int GET_API = 0x13000004;
	public static final int CALL_API = 0x13000005;
	public static final int CHECK_SESSION = 0x13000006;
	public static final int LOGIN = 0x13000007;
	public static final int LOGOUT = 0x13000008;
	public static final int LIST_USER = 0x13000009;
	public static final int GET_USER = 0x1300000A;
	public static final int UPDATE_USER = 0x1300000B;
	// public static final int LIST_LOG = 0x1300000C;
	public static final int LIST_POOL_VM = 0x1300000D;
	public static final int GET_POOL_VM = 0x1300000E;
	public static final int LIST_DRIVER = 0x1300000F;
	public static final int GET_DRIVER = 0x13000010;
	public static final int ADD_POOL = 0x13000011;
	public static final int REMOVE_POOL = 0x13000012;
	public static final int UPDATE_POOL = 0x13000013;
	public static final int LIST_POOL_TEMPLATE = 0x13000014;
	public static final int GET_POOL_TEMPLATE = 0x13000015;

	public static final int CREATE_VM_FROM_SKYPORT = 0x13000016;
	public static final int START_VM_FROM_SKYPORT = 0x13000017;
	public static final int STOP_VM_FROM_SKYPORT = 0x13000018;
	public static final int UPDATE_VM_FROM_SKYPORT = 0x13000019;
	public static final int REMOVE_VM_FROM_SKYPORT = 0x1300001A;
	public static final int RESTART_VM_FROM_SKYPORT = 0x1300001B;
	public static final int CREATE_VNC_CHANNEL_FROM_SKYPORT = 0x1300001C;
	public static final int LIST_POOL_RESOURCE = 0x1300001D;
	public static final int GET_POOL_RESOURCE = 0x1300001E;
	public static final int LIST_EVENT = 0x1300001F;
	public static final int GET_EVENT = 0x13000020;
	public static final int GET_VNC = 0x13000021;
	public static final int TEST_CONNECTION = 0x13000022;
	public static final int ADD_DISK_FROM_SKYPORT = 0x13000023;
	public static final int REMOVE_DISK_FROM_SKYPORT = 0x13000024;
	public static final int CONNECT_VM = 0x13000025;
	public static final int GET_VNC_INFO = 0x13000026;
	public static final int ACTIVE_POOL = 0x13000027;
	public static final int LIST_POOL_NETWORK = 0x13000028;
	public static final int GET_POOL_NETWORK = 0x13000029;
	public static final int ADD_NIC_FROM_SKYPORT = 0x1300002A;
	public static final int REMOVE_NIC_FROM_SKYPORT = 0x1300002B;

	public static final int LIST_GROUP = 0x1300002C;
	public static final int GET_GROUP = 0x1300002D;
	public static final int ADD_GROUP = 0x1300002E;
	public static final int UPDATE_GROUP = 0x1300002F;
	public static final int REMOVE_GROUP = 0x13000030;

	public static final int LIST_ROLE = 0x13000031;
	public static final int GET_ROLE = 0x13000032;
	public static final int ADD_ROLE = 0x13000033;
	public static final int UPDATE_ROLE = 0x13000034;
	public static final int REMOVE_ROLE = 0x13000035;
	public static final int LIST_PERMISSION = 0x13000036;
	public static final int GET_PERMISSION = 0x13000037;

	public static final int ADD_USER = 0x13000038;
	public static final int REMOVE_USER = 0x13000039;
	public static final int LIST_POSSIBLE_ROLE = 0x1300003A;
	public static final int LIST_POSSIBLE_SCOPE = 0x1300003B;
	public static final int GET_NONCE = 0x1300003C;

	public static final int WEBSOCKIFY = 0x1300003D;
	public static final int RELEASE_WEBSOCKET = 0x1300003E;

	public static final int CMDCODE_UNKNOWN = 0x99920001;
	public static final int EXECUTION_FAIL = 0x99920002;

	public static final String PARAM_CMD = "cmd";

	public static final int LIST_POOL_VM_NICS = 0x1300003F;
	public static final int FLUSH_CACHE = 0x13000040;
	public static final int LIST_POOL_HOST = 0x13000041;
	public static final int GET_POOL_HOST = 0x13000042;
	public static final int CANCEL_TASK = 0x13000043;

	static {

		cmdTable = new ImmutableMap.Builder<Integer, String>()
				.put(CMD.LIST_POOL, "ListPool")
				.put(CMD.GET_POOL, "GetPool")
				.put(CMD.LIST_API, "ListApi")
				.put(CMD.GET_API, "GetApi")
				.put(CMD.CALL_API, "CallApi")
				.put(CMD.CHECK_SESSION, "CheckSession")
				.put(CMD.LOGIN, "Login")
				.put(CMD.LOGOUT, "Logout")
				.put(CMD.LIST_USER, "ListUser")
				.put(CMD.GET_USER, "GetUser")
				.put(CMD.UPDATE_USER, "UpdateUser")
				// .put(CMD.LIST_LOG, "ListLog")
				.put(CMD.LIST_POOL_VM, "ListVm")
				.put(CMD.GET_POOL_VM, "GetVm")
				.put(CMD.LIST_DRIVER, "ListDriver")
				.put(CMD.GET_DRIVER, "GetDriver")
				.put(CMD.ADD_POOL, "AddPool")
				.put(CMD.UPDATE_POOL, "UpdatePool")
				.put(CMD.REMOVE_POOL, "RemovePool")
				.put(CMD.ACTIVE_POOL, "ActivePool")
				.put(CMD.LIST_POOL_TEMPLATE, "ListTemplate")
				.put(CMD.GET_POOL_TEMPLATE, "GetTemplate")
				.put(CMD.LIST_POOL_HOST, "ListHost")
				.put(CMD.GET_POOL_HOST, "GetHost")
				.put(CMD.LIST_POOL_RESOURCE, "ListResource")
				.put(CMD.GET_POOL_RESOURCE, "GetResource")
				.put(CMD.CREATE_VM_FROM_SKYPORT, "CreateVm")
				.put(CMD.REMOVE_VM_FROM_SKYPORT, "RemoveVm")
				.put(CMD.START_VM_FROM_SKYPORT, "StartVm")
				.put(CMD.STOP_VM_FROM_SKYPORT, "StopVm")
				.put(CMD.RESTART_VM_FROM_SKYPORT, "RestartVm")
				// .put(CMD.CREATE_VNC_CHANNEL_FROM_SKYPORT,
				// new CreateVncChannel")
				.put(CMD.LIST_EVENT, "ListEvent")
				.put(CMD.GET_EVENT, "GetEvent")
				// .put(CMD.GET_VNC,"GetVncInfo")
				.put(CMD.UPDATE_VM_FROM_SKYPORT, "UpdateVm").put(CMD.ADD_DISK_FROM_SKYPORT, "AddDisk")
				.put(CMD.REMOVE_DISK_FROM_SKYPORT, "RemoveDisk").put(CMD.ADD_NIC_FROM_SKYPORT, "AddNic")
				.put(CMD.REMOVE_NIC_FROM_SKYPORT, "RemoveNic").put(CMD.TEST_CONNECTION, "TestConnection")
				.put(CMD.CONNECT_VM, "ConnectVm").put(CMD.LIST_POOL_NETWORK, "ListNetwork")
				.put(CMD.GET_POOL_NETWORK, "GetNetwork").put(CMD.LIST_GROUP, "ListGroup").put(CMD.GET_GROUP, "GetGroup")
				.put(CMD.ADD_GROUP, "AddGroup").put(CMD.UPDATE_GROUP, "UpdateGroup").put(CMD.REMOVE_GROUP, "RemoveGroup")
				.put(CMD.LIST_ROLE, "ListRole").put(CMD.GET_ROLE, "GetRole").put(CMD.ADD_ROLE, "AddRole")
				.put(CMD.UPDATE_ROLE, "UpdateRole").put(CMD.REMOVE_ROLE, "RemoveRole")
				.put(CMD.LIST_PERMISSION, "ListPermission").put(CMD.GET_PERMISSION, "GetPermission")
				.put(CMD.ADD_USER, "AddUser").put(CMD.REMOVE_USER, "RemoveUser").put(CMD.GET_NONCE, "GetNonce")
				.put(CMD.LIST_POSSIBLE_SCOPE, "ListScope").put(CMD.LIST_POOL_VM_NICS, "ListNics")
				.put(CMD.FLUSH_CACHE, "FlushCache").put(CMD.CANCEL_TASK, "CancelTask")
				.put(CMD.EXECUTION_FAIL, "ExecutionFail").build();

	}


	public static String getCmd(String cmd) {
		int i;
		try {
			i = Integer.decode(cmd);
		} catch (Exception e) {
			return "Unknown";
		}

		return cmdTable.containsKey(i) ? cmdTable.get(i) : "Unknown";

	}

	public static String getCmd(int cmd) {
		return cmdTable.containsKey(cmd) ? cmdTable.get(cmd) : "Unknown";

	}

	private CMD() {

	}
}
