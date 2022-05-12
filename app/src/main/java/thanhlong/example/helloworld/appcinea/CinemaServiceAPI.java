package thanhlong.example.helloworld.appcinea;
import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class CinemaServiceAPI implements CinemaServiceInterface{
    @Override
    public String callHello(){

        return new CinemaService().callHello();
    }

    @Override
    public String callLogin(String username, String password) {
        return new CinemaService().callLogin(username, password);
    }

    //WS value
    enum CinemaServiceMethod {
        //Add more keys method at here
        HELLO("hello"),
        LOGIN("login");

        private String method;
        private CinemaServiceMethod(String method){
            this.method = method;
        }

    }

    //WS class
    private class CinemaService extends AsyncTask<Void, Void, Void> implements CinemaServiceInterface {
        //Declare CinemaService properties
        private String method;
        Map<String, Object> inputs;
        private String result;
        private final String NAMESPACE = "http://cinema_service/";
        private final String URL = "http://25.33.36.170:8080/CinemaAPIs/CinemaService?wsdl";

        //Method from API
        private void callAPIMethod () {
            final String SOAP_ACTION = NAMESPACE + method;
            try {
                SoapObject request = new SoapObject(NAMESPACE, method);
                Set<String> params = inputs.keySet();
                for(String param: params){
                    request.addProperty(param, inputs.get(param));
                    request.addProperty(param, inputs.get(param));
                }
                //request.addProperty("name", txt);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                HttpTransportSE ht = new HttpTransportSE(URL);
                ht.call(SOAP_ACTION, envelope);
                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                result = response.toString();
            } catch (Exception e) {
                result =  e.toString();
                e.printStackTrace();
            }
        }

        //Private method
        private void doAll(){
            this.execute();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //AsyncTask override method
        @Override
        protected Void doInBackground(Void... voids) {
            callAPIMethod();
            return null;
        }

        //CinemaServiceInterface override method
        @Override
        public String callHello(){
            this.method = CinemaServiceMethod.HELLO.method;
            inputs = new HashMap<>();
            this.doAll();
            return result.toString();
        }

        @Override
        public String callLogin(String username, String password) {
            this.method = CinemaServiceMethod.LOGIN.method;
            inputs = new HashMap<>();
            inputs.put("username", username);
            inputs.put("password", password);
            this.doAll();
            return result.toString();
        }
    }
}
