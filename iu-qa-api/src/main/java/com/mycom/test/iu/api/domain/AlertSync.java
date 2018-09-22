package com.mycom.test.iu.api.domain;

import com.mycom.test.nova.utils.RestRequest;

public class AlertSync
{
   private AlertSync()
   {

   }

   private static String URL_GenAlert = "/mox/updateNxalert";
   private static String DEFAULT_BASE_URL_PROPERTY = "base.url";
   private static String alertDef = "";
   private static String alertManageObj = "";
   private static String affectedClass = "";
   private static final String confHeaderAccept = "application/json";
   private static final String confContentType = "application/json";

   public static void setAlertDetails(String alertName, String amo, String amoClass)
   {
      alertDef = alertName;
      alertManageObj = amo;
      affectedClass = amoClass;
   }

   public static String getPayLoad()
   {
      StringBuffer payLoad = new StringBuffer();
      payLoad = getAlertGenPayload(payLoad);
      String newPayLoad = payLoad.toString().replaceAll(",}", "}");
      System.out.println(newPayLoad);
      return newPayLoad;
   }

   private static String alertDef()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append(String.format("\"alarmName\":\"%s\",", alertDef));
      return buffer.toString();
   }

   private static String alertManageObj()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append(String.format("\"alarmManagedObjectInstance\":\"%s\",", alertManageObj));
      return buffer.toString();
   }

   private static String affectedClass()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append(String.format("\"alarmManagedObjectClass\":\"%s\",", affectedClass));
      return buffer.toString();
   }

   public static StringBuffer getAlertGenPayload(StringBuffer payLoad)
   {
      payLoad.append(String.format("{"));
      if (alertDef != null && !alertDef.isEmpty())
      {
         payLoad.append(alertDef());
      }
      if (alertManageObj != null && !alertManageObj.isEmpty())
      {
         payLoad.append(alertManageObj());
      }
      if (affectedClass != null && !affectedClass.isEmpty())
      {
         payLoad.append(affectedClass());
      }
      payLoad.append(String.format("}"));
      return payLoad;
   }

   public static void setBaseURL()
   {
      DEFAULT_BASE_URL_PROPERTY = System.getProperty("base.url");
   }

   public static void genAlert(int statusCode)
   {
      RestRequest.setAddURLV1(false);
      RestRequest.getBasicAuth(DEFAULT_BASE_URL_PROPERTY, confHeaderAccept, confContentType).sendRequest(URL_GenAlert, "post", getPayLoad(), statusCode);
   }
}
