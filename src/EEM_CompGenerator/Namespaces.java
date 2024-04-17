package EEM_CompGenerator;

public interface Namespaces {
   String HEADER = ".h";
   String SOURCE = ".c";
   String PRIVATE = "private";
   String PUBLIC = "public";
   String DEFINITION = "definition";
   String DEFINE = "define ";
   String IFNDEF = "ifndef ";
   String INCLUDE = "include ";
   String IF = "if ";
   String ELIF = "elif ";
   String ELSE = "else ";
   String ENDIF = "endif ";
   String TYPEDEF = "typedef ";
   String ENUM = "enum ";
   String INT8TYPE = "int8_t ";
   String INT16TYPE = "int16_t ";
   String INT32TYPE = "int32_t ";
   String INT64TYPE = "int64_t ";
   String UINT8TYPE = "uint8_t ";
   String UINT16TYPE = "uint16_t ";
   String UINT32TYPE = "uint32_t ";
   String UINT64TYPE = "uint64_t ";
   String FLOATTYPE = "float ";
   String DOUBLETYPE = "double ";
   String CHARTYPE = "char ";
   String STRUCTTYPE = "struct ";
   String UNIONTYPE = "union ";

   String nameGeneration();
}
