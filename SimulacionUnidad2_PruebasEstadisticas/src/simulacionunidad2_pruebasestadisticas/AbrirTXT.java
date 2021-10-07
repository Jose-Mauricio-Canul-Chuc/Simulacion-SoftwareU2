
package simulacionunidad2_pruebasestadisticas;

import java.io.*;
import static simulacionunidad2_pruebasestadisticas.Interfaz.Datos;
import static simulacionunidad2_pruebasestadisticas.Interfaz.entrada;
import static simulacionunidad2_pruebasestadisticas.Interfaz.tabla;
import static simulacionunidad2_pruebasestadisticas.Interfaz.sumatoria;

/**
 *
 * @author J. Mauricio
 */
public class AbrirTXT {
    public static Double[] valores = new Double[100];
    public String abrirArchivo(File archivo){
        String documento="";
        String document="";
        Double sumar,sumand = 0.0;
        int suma=0;
        try{
            entrada=new FileInputStream(archivo);
            String ascci;
            BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
            while((ascci=br.readLine())!=null){
                String caracter=(String)ascci;
                documento=caracter;
                sumar = Double.parseDouble(documento);
                sumand += sumar;
                valores[suma] = sumar;
                String[]info=new String[1];
                info[0]=documento;
                tabla.addRow(info);
                suma++;
            }
            br.close();
        } catch (Exception e) {
        }
        try{
            entrada=new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!=-1){
                char caracter=(char)ascci;
                document+=caracter;
            }
        } catch (Exception e) {
        }
        String sumando = Double.toString(sumand);
        sumatoria.setText(sumando);
        String sumado = Integer.toString(suma);
        Datos.setText(sumado);
        return document;
    }
}
