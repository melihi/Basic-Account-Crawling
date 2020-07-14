import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class GetData {

    public void data() {

        try {

            String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
            String random = "";
            int randnum = 1 + (int) (Math.random() * 10);

            Random rnd = new Random();
            for (int i = 1; i <= randnum; i++) {
                char c = chars.charAt(rnd.nextInt(chars.length()));
                random += c;

            }
            //  System.out.println(randnum);
            System.out.println(random);

            Document doc = Jsoup.connect("http://www.notes.io/" + random).get();
            String textContents = doc.select("div.notesTextArea").first().text();
            System.out.println(textContents);
            saveData(textContents, random);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void saveData(String data, String fileName) {

        try {



            if (data.equals("note is null")) {
                System.out.println("Null Note !");
                data();
            } else {

                if (data.contains("MATCH DETAILS") || data.contains("hello@notes.io") || data.contains("Kino.vooa.pl") || data.contains("select max(precio), min(precio) from historico where fecha>'2011-06-22 11:30';")) {

                    System.out.println("SPAM [}{}{}{}{{}[");
                    data();
                } else {
                    if (data.contains("pass") || data.contains("username") || data.contains(":") || data.contains("facebook") || data.contains("user")
                            || data.contains("twitter") || data.contains("пароль") || data.contains("Kennwort") || data.contains("sifre") || data.contains("admin")
                            || data.contains("şifre") || data.contains("gmail") || data.contains("yahooo") || data.contains("@") || data.contains("administrator")
                            || data.contains("Root") || data.contains("root") || data.contains("ip") || data.contains("adress") || data.contains("Adress") || data.contains("Street")
                            || data.contains("street") || data.contains("adress") || data.contains("location") || data.contains("macadress") || data.contains("mac") || data.contains("google") || data.contains("mail")
                            || data.contains("Mail") || data.contains("Important") || data.contains("important") || data.contains("e-mail") || data.contains("premium") || data.contains("Key") || data.contains("key") || data.contains("login")
                            || data.contains("Login") || data.contains("Sign in") || data.contains("Sign Up") || data.contains("Sign up") || data.contains("contraseña") || data.contains("nombre de usuario") || data.contains("iniciar sesión")
                            || data.contains("administración") || data.contains("administrateur") || data.contains("instagram") || data.contains("ig") || data.contains("insta") || data.contains("meet") || data.contains("toplanti") || data.contains("job")
                            || data.contains("work") || data.contains("intelligence") || data.contains("iban") || data.contains("IBAN") || data.contains("CC") || data.contains("cc") || data.contains("Credit card") || data.contains("Insta")) {

                        FileWriter writer = new FileWriter("notesio"+fileName+".txt");
                        BufferedWriter buffer = new BufferedWriter(writer);
                        buffer.write(data + "\n" + "**************************************" + "\n");

                        System.out.println("Success");
                        buffer.close();
                        data();

                    } else {
                        System.out.println("No match word @@!");
                        data();
                    }

                }


            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
