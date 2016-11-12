/*
 * 1.saveResource
   2..addResourceType
   3.saver.createFolder
    4.save("http://xxx.pdf",saver)
 */
package AñadirRecursos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hugo
 */
public class ResourceSaver 
{
    
     private Map<String, String> types = new HashMap<>(); //<PatternType, FolderToSave>
 
 
public void addResourceType(String patternType, String folderToSave){
types.put(patternType, folderToSave);
}
 
public void createFolderTree() throws IOException{
for(String pattern: types.keySet()){
createFolder(types.get(pattern));
}
}
 
public void saveResource(String resource)
throws MalformedURLException, IOException, Exception{
boolean saved = false;
//Clase Creada  per treballar amb web-address
//posar "https://www.xxx.com", String i amb  https://
URL url = new URL(resource);
//object is created every time by calling the openConnection URL.
URLConnection urlCon = (url).openConnection();
//Obtiene el valor Map llamado types
//Set keyset=newmap.keySet();
//sout( keyset)
for(String pattern: types.keySet()){
//Conexion URL abierta obtiene  el tipo de documento que es 
// 
//Creamos en Regex  como parametro de busqueda dentro de INPUT
//En Pattern se  compila  como parametro de busqueda
//Matcher busca el string compilado en Pattern ademas de marcar
//las posiciones exactas    
    
// String REGEX = "\\bcat\\b";
//String INPUT = "cat cat cat cattie cat";    
//Pattern p = Pattern.compile(REGEX);
//Matcher m = p.matcher(INPUT);   // get a matcher object
// boolean b = m.matches();  si coincide todo el parametro o no
//
if(urlCon.getContentType().matches(pattern)){
//Obtener ruta  .getpath()  
//.lastIndexof("/")  marcar  la ultima posicion
int lastSep = url.getPath().lastIndexOf("/")+1;
String name = url.getPath().substring(lastSep);
//Genera un Inputstream(fluxos de bytes d'entrada) sobre el proceso. 
//El stream obtiene un pipe sobre la salida del proceso. 
// types.get(pattern)  Retorno el valor del valor especifico de Map
saveTo(urlCon.getInputStream(), types.get(pattern), name);
saved=true;
break;
}
}
if(!saved){
throw new Exception("Unknown type");
}
}
 
private void saveTo(InputStream inputStream, String folder, String name)
throws FileNotFoundException, IOException {
int readChars;
FileOutputStream fileOut = new FileOutputStream(new File(folder, name));
byte[] buffer = new byte[1024];
//inputStream.read(buffer) llegir buffer
while((readChars=inputStream.read(buffer))!=-1){
fileOut.write(buffer, 0, readChars);
}
}
 
private void createFolder(String folder) throws IOException{
File file = new File(folder);
if(!file.exists()&&!file.mkdirs()){
throw new IOException("Denied permission");
}
} 
    
    
    
    
    
    
    
    
    
}
