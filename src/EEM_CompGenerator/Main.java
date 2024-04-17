package EEM_CompGenerator;

public class Main {
   public static void main(String[] args) 
   {
      String[] testNames = new String[]{"a", "b", "c", "d"};
      String compName = "MyWrapper";
      
      SourceGen source = new SourceGen(compName, testNames);
      PrivateGen priv = new PrivateGen(compName);
      PublicGen pub = new PublicGen(compName);
      DefinitionGen def = new DefinitionGen(compName);
      
      System.out.println(source.toString());
      System.out.println(priv.toString());
      System.out.println(pub.toString());
      System.out.println(def.toString());
      
      Definition definition = new Definition();
      DataDefinition[] datas = new DataDefinition[]{new DataDefinition(), null};
      datas[0].setDataName("age");
      datas[0].setDataType("int");
      datas[1] = new DataDefinition();
      datas[1].setDataName("name");
      datas[1].setDataType("String");
      
      String[] structDataComments = new String[]{"age of peaople", "name of people"};
      StructureDefinition[] structures = new StructureDefinition[]
    		  {
    				  new StructureDefinition(
    						  "Person", 
    						  new String[]{"int", "String"}, 
    						  new String[]{"age", "name"}
    						  )
    		   };
   
      structures[0].setDataComments(structDataComments); //@TODO make it with ctr
      
      
      EnumDefinition[] enums = new EnumDefinition[]
    		  {
    				  new EnumDefinition(
    						  "Status", 
    						  new String[]{"Active", "Inactive", "Suspended"}
    						  )
    				  };
      
      
      definition.setDatas(datas);
      definition.setStructures(structures);
      definition.setEnums(enums);
      
      def.setDefs(datas, structures, enums);
      def.headerCommentPhase();
      def.headerPhase();
      
      String generatedCode = def.build();
      
      System.out.println(generatedCode);

   }
}
