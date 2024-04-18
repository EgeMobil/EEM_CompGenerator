package EEM_CompGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
   public static void main(String[] args) throws IOException 
   {
      String authorName = "atakan.ertekin";
      String compName 	= "SystemConditionObserver";
      
      String[]   otherComponents = {
    		  "WatchDogManager", 
    		  "EcuStateManager", 
    		  "MotorDriverController", 
    		  "CommunicationNetworkManager"
    		  };
      
      String[]   runableNames = {"Refresh", "Invoke", "Timing", "DataReceived"};
      String[]   runableReturnTypes = {"uint32_t*", "char", "boolean", "uint16_t"};
      String[][] runableVariablesTypes = {
          {"uint32_t", "char", "uint16_t"},
          {"uint8_t", "char"},
          {"uint64_t*", "char", "uint16_t", "uint16_t"},
          {"char*"}
      };
      String[][] runableVariablesNames = {
    		{"data", "var", "param"},
            {"param", "var"},
            {"varx", "vary", "varz", "vark"},
            {"var"}        
      };
      String[]   runableDescriptions = {
    		  "This runable works for refresh periodically", 
    		  "This runable works for Invoke operation ", 
    		  "This runable works periodically by timing", 
    		  "This runable works only when data received"
      };
      
      Runable runables = new Runable(runableNames, runableReturnTypes, runableVariablesTypes, runableVariablesNames, runableDescriptions);
      
      SourceGen source = new SourceGen(compName, authorName , otherComponents , runables );
      PrivateGen priv = new PrivateGen(compName, authorName , otherComponents , runables );
      PublicGen pub = new PublicGen(compName, authorName , otherComponents , runables ) ;
      DefinitionGen def = new DefinitionGen(compName, authorName , otherComponents) ;
      
      System.out.println(source.toString());
      System.out.println(priv.toString());
      System.out.println(pub.toString());
      System.out.println(def.toString());
      
      DataDefinition[] datas = new DataDefinition[]
    		  {
    				  new DataDefinition(
    						  "int", "String", "cmnt1"    						    
    				  ) ,
    				  new DataDefinition(
    						  "age", "name" , "cmnt2"   						    
    				  ) 
    		  };
      
      StructureDefinition[] structures = new StructureDefinition[]
    		  {
    				  new StructureDefinition(
    						  "Person", "Person Structure Defs" ,
    						  new String[]{"int", "String"}, 
    						  new String[]{"year", "code"},
    						  new String[]{"year of person", "code of person"}
    						  ) ,
    				  new StructureDefinition(
    						  "Identifier", "Identifier Structure Defs" ,
    						  new String[]{"int", "String"}, 
    						  new String[]{"year", "code"},
    						  new String[]{"year of person", "code of person"}
    						  )
    		   };
    
      
      EnumDefinition[] enums = new EnumDefinition[]
    		  {
    				  new EnumDefinition(
    						  "Status", "Status Enumaration Defs" ,
    						  new String[]{"Active", "Inactive", "Suspended"}
    						  ) ,
    				  
    				  new EnumDefinition(
    						  "SysCase", "SysCase Enumaration Defs" ,
    						  new String[]{"Pre-init", "Post-init", "Routine"}
    						  )
    				  
    				  };
      
      Definition definition = new Definition(datas , structures , enums);  
      def.setDefs(definition);

      System.out.println("********************************************");
      String DefgeneratedCode = def.build();
      System.out.println(DefgeneratedCode);
      
      //System.out.println("********************************************");
      //String PrivgeneratedCode = priv.build();     
      //System.out.println(PrivgeneratedCode);
      
      //System.out.println("********************************************");
      //String PubgeneratedCode = pub.build();     
      //System.out.println(PubgeneratedCode);
      
      //System.out.println("********************************************");
      //String SrcgeneratedCodes = source.build();
      //System.out.println(SrcgeneratedCodes);

      String compPath = "C:/Users/atakan.ertekin/Desktop/Java-WS/" + compName;
      File compFile = new File(compPath);
      
      boolean compFileStatus = compFile.mkdir();
      if(compFileStatus) {
    	  System.out.println("Success!");
    	  
    	  String incPath = "C:/Users/atakan.ertekin/Desktop/Java-WS/" + compName + "/Inc";
    	  String srcPath = "C:/Users/atakan.ertekin/Desktop/Java-WS/" + compName + "/Src";
    	  
    	  File incFile = new File(incPath);
    	  File srcFile = new File(srcPath);
    	  
    	  incFile.mkdir();
    	  srcFile.mkdir();
    	  
    	  File definitionFile = new File( incPath + "/" + def.nameGeneration() );
    	  definitionFile.createNewFile();
    	  
    	  FileWriter cWriter = new FileWriter(definitionFile);
          BufferedWriter cBufferedWriter = new BufferedWriter(cWriter);
          cBufferedWriter.write(DefgeneratedCode);
          cBufferedWriter.close();
      }
      else
      {
    	  System.out.println("Failed");
      }
   }
   
}
