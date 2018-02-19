package websider;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

@Path("loginsuccess")
public class LoginSucces {

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String postLogin(@FormParam("brugernavn") String bn,
          @FormParam("adgangskode") String kode) throws IOException {

    //Initialize Mustache renderer
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile("loginsuccess.mustache");

    //Set some data
    HashMap<String, Object> mustacheData = new HashMap<String, Object>();
    mustacheData.put("brugernavnet", bn);

    //render template with data
    StringWriter writer = new StringWriter();
    m.execute(writer, mustacheData).flush();
    return writer.toString();
  }
}
