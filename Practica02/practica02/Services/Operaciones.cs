using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes {
        public String Saludar(string nombre){
            String msj = "Hola "+nombre;
            return msj;
        }
        public String Mostrar(int id){
            return "X";
        }
    }
}
