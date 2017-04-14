package ru.in.watcher.service;

public enum CauseCode {
// https://support.sonus.net/display/VXDOC471/Mapping+Q.850+to+SIP+Responses
	UNALLOCATED(1),
	NO_ROUTE_TO_TRANSIT_NET(2),
	NO_ROUTE_TO_DEST(3),
	SEND_SPECIAL_TONE(4),
	MISDIALED_TRUNK_PREFIX(5),
	ALL_CLEAR(16),
	USER_BUSY(17),
	NO_USER_RESPONSE(18),
	NO_ANSWER(19),
	SUBSCRIBER_ABSENT(20),
	CALL_REJECTED(21),
	NUMBER_CHANGED(22),
	REJECTED_DUE_TO_ACR_SUPP_SERVICES(24),
	EXCHANGE_ROUTING_ERROR(25),
	DESTINATION_OUT_OF_ORDER(27),
	ADDRESS_INCOMPLETE(28),
	FACILITY_REJECTED(29),
	NORMAL_UNSPECIFIED(31),
	NO_CIRCUIT_AVAILABLE(34),
	NETWORK_OUT_OF_ORDER(38),
	TEMPORARY_FAILURE(41),
	SWITCH_EQUIPMENT_CONGESTION(42),
	USER_INFORMATION_DISCARDED(43),
	REQUESTED_CIRCUIT_UNAVAILABLE(44),
	PREEMPTION(47),
	RESOURCE_UNAVAILABLE(47),
	FACILITY_NOT_SUBSCRIBED(50),
	INCOMING_CALL_BARRED_WITHIN_CUG(55),
	BEARER_CAPABILITY_NOT_AUTHORIZED(57),
	BEARER_CAPABILITY_NOT_AVAILABLE(58),
	SERVICE_OR_OPTION_NOT_AVAILABLE(63),
	BEARER_CAPABILITY_NOT_IMPLEMENTED(65),
	FACILITY_NOT_IMPLEMENTED(69),
	RESTRICTED_DIGITAL_BEARED_AVAILABLE(70),
	SERVICE_OR_OPTION_NOT_IMPLEMENTED(79),
	INVALID_CALL_REFERENCE(81),
	CALLED_USER_NOT_MEMBER_OF_CUG(87),
	INCOMPATIBLE_DESTINATION(88),
	INVALID_TRANSIT_NETWORK_SELECTION(91),
	INVALID_MESSAGE_UNSPECIFIED(95),
	MANDATORY_ELEMENT_MISSING(96),
	MESSAGE_TYPE_NON_EXISTENT(97),
	PARAMETER_NON_EXISTENT_DISCARD(99),
	INVALID_PARAMETER_CONTENT(100),
	TIMEOUT_RECOVERY(102),
	PARAMETER_NON_EXISTENT_PASS_ALONG(103),
	MESSAGE_WITH_UNRECOGNIZED_PARAMETER_DISCARDED(110),
	PROTOCOL_ERROR(111),
	INTERNETWORKING_UNSPECIFIED(127);
	
	private final int code;
	CauseCode(int c) {
		this.code = c;
	}
	
	public static int getCauseCodeFromSip(int sipStatus) {
		switch (sipStatus) {
		case 404: return UNALLOCATED.getCode();
		case 486: return USER_BUSY.getCode();
		case 408: return NO_USER_RESPONSE.getCode();
		case 480: return NO_ANSWER.getCode();
		// ... https://support.sonus.net/display/VXDOC471/Mapping+Q.850+to+SIP+Responses

		default:
			return NORMAL_UNSPECIFIED.getCode();
		}
	}
	public int getCode() {	return code;	}
}