import net.jimmc.jshortcut.JShellLink;

 

public class Sc {

 

JShellLink link;

String filePath;

 

public Sc() {

 

try {

link = new JShellLink();

filePath = "C:\\Program Files\\Internet Explorer\\iexplore.exe";

 

} catch (Exception e) {

}

}

 

public void createDesktopShortcut() {

try {

 

link.setFolder("C:\\Users\\alok\\Desktop");

link.setName("ie");

link.setPath(filePath);

link.save();

} catch (Exception ex) {

ex.printStackTrace();

}

}

 

public static void main(String a[]) {

Sc sc = new Sc();

sc.createDesktopShortcut();

}

}