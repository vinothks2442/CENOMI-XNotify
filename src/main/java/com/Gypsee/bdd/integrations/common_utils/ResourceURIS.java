package com.Gypsee.bdd.integrations.common_utils;

public class ResourceURIS {

	private static final String getDrivingAlertsByTripId = "/vehicle/driving/alerts/v2?page=1&size=20&tripid=6b0d9da0-37b4-414b-a70e-dc7642ceacf1";
	private static final String getDrivingAlertsByTripIdInvalidURI = "/vehicle/driving";

	private static final String getTripsByUserID = "/user/trip/10bb8e55-597a-443d-a3f0-1ef1db2b6a84?isBasic=false&size=20&page=0&isShowInValidTrips=false&isFleetView=false&periodFrom=2024-05-01&periodTo=2024-05-01";
	private static final String getTripsByUserIDInvalidURI = "/vehicle/driving";

	private static final String sendOtp = "/mobile/send/otp?checkUser=false&version=v3";
	private static final String sendOtpInvalidUri = "/mobile/send";
	private static final String sendOtpInvalidCountryCode = "/mobile/send/otp?checkUser=false&version=v3";

	private static final String GetOtp = "/mobile/send/otp?checkUser=true&version=v2";
	private static final String GetOtpInvalidUri = "/mobile/send";
	private static final String GetOtpInvalidCountryCode = "/mobile/send/otp?checkUser=true&version=v2";
	private static final String GetOtpInvalidPhoneNumber = "/mobile/send/otp?checkUser=true&version=v2";

	private static final String VerifyOtp = "/mobile/otp/verify?checkUser=false&version=v3";
	private static final String VerifyOtpInvalidUri = "/mobile/otp";
	private static final String VerifyOtpInvalidCountryCode = "/mobile/otp/verify?checkUser=false&version=v3";
	private static final String VerifyOtpInvalidPhoneNumber = "/mobile/otp/verify?checkUser=false&version=v3";

	private static final String getLatituteLongitude = "/trip/6b0d9da0-37b4-414b-a70e-dc7642ceacf1/latlongs";
	private static final String getLatituteLongitudeInvalidUri = "/vehicle/driving";
	private static final String Post_addDevice = "/register/user/device";

	private static final String vehicleListByUserID = "/gypsee/user/{USER_ID}/vehicles?isDocuments=false&isAlerts=false&isTrainingData=false";
	private static final String verifyOtp1 = "/gypsee/mobile/otp/verify?checkUser=false&version=v3";
	private static final String getRegisteredDevice = "/gypsee/user/{USER_ID}/registered/devices";
	private static final String StartTrip = "/user/trip/start";
	private static final String tripEnd  ="/user/trip/end/v2?isGenerateVHSReport=true&isSendNotification=true";

	public static String getResourceURI(String requestName) {
		switch (requestName) {

		case "GetOtpInvalidCountryCode":
			return GetOtpInvalidCountryCode;
		case "GetOtpInvalidPhoneNumber":
			return GetOtpInvalidPhoneNumber;
		case "VerifyOtp":
			return VerifyOtp;
		case "Post_addDevice":
			return Post_addDevice;
		case "GetOtp":
			return GetOtp;
		case "GetOtpInvalidUri":
			return GetOtpInvalidUri;
		case "VerifyOtpInvalidUri":
			return VerifyOtpInvalidUri;
		case "VerifyOtpInvalidCountryCode":
			return VerifyOtpInvalidCountryCode;
		case "VerifyOtpInvalidPhoneNumber":
			return VerifyOtpInvalidPhoneNumber;
		case "sendOtpInvalidCountryCode":
			return sendOtpInvalidCountryCode;

		case "sendOtp":
			return sendOtp;
		case "sendOtpInvalidUri":
			return sendOtpInvalidUri;

		case "getLatituteLongitude":
			return getLatituteLongitude;
		case "getLatituteLongitudeInvalidUri":
			return getLatituteLongitudeInvalidUri;

		case "getDrivingAlertsByTripId":
			return getDrivingAlertsByTripId;
		case "getDrivingAlertsByTripIdInvalidURI":
			return getDrivingAlertsByTripIdInvalidURI;

		case "getTripsByUserID":
			return getTripsByUserID;
		case "getTripsByUserIDInvalidURI":
			return getTripsByUserIDInvalidURI;
		case "verifyOtp1":
			return verifyOtp1;
		case "vehicleListByUserID":
			return vehicleListByUserID;
		case "getRegisteredDevice":
			return getRegisteredDevice;
		case "StartTrip":
			return StartTrip;
		case "tripEnd":
            return tripEnd;

		default:
			throw new RuntimeException("Resource uri not defined for the specific file name - " + requestName);
		}
	}
}
