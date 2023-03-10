var parser, xmlDoc, cadena, text;
var re, rr, tt, id;
var inicio = "<![CDATA[?";
var fin = "]]>";
parser = new DOMParser();
xmlDoc = parser.parseFromString(text,"text/xml");
re = xmlDoc.getElementsByTagName("cfdi:Emisor")[0].childNodes[2].nodeValue;
rr = xmlDoc.getElementsByTagName("cfdi:Receptor")[0].childNodes[2].nodeValue;
tt = xmlDoc.getElementsByTagName("cfdi:Comprobante")[0].childNodes[5].nodeValue;
id = xmlDoc.getElementsByTagName("tfd:TimbreFiscalDigital")[0].childNodes[7].nodeValue;
cadena = inicio.concat("re=",re,"&rr=",rr,"&tt=",tt,"&id=",id,fin);

window.print(cadena);

