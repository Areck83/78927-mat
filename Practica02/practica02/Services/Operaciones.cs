using System;
using System.Collections.ObjectModel;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes {
        private List<string> nombres = new List<string>();
        public String Saludar(string nombre){
            nombres.Add(nombre);
            String msj = "Hola "+nombre;
            return msj;
        }
        public String Mostrar(int id){
            return nombres[id];
        }
    }
}
