package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrivateGen extends CodeGenerator implements Namespaces, Functionallity {
   public int publicHeaderCount;

   public PrivateGen(String _compName , String _author , String[] _otherComps, Runable _runable) {
      super(_compName, _author, _otherComps, _runable);
   }

   public PrivateGen() {
      super("NOT_ENTERED", null, null, null);
   }

   public String toString() {
      return "Private file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_private.h";
      return fileName;
   }
  

   public void headerCommentPhase(List<String> phase) {
	   this.setDate(LocalDate.now());
	   phase.add("/* ");
	   phase.add(" * " + this.nameGeneration());
	   phase.add(" * ");
	   phase.add(" *  Created on: " + String.valueOf(this.getDate()));
	   phase.add(" *      Author: " + this.getAuthor());
	   phase.add("*/ ");
	   phase.add(" ");
   }

   public void headerPhase(List<String> phase) {
	      
	   phase.add(PREPROCESSOR + IFNDEF + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PRIVATE_H_");
	   phase.add(PREPROCESSOR + DEFINE + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PRIVATE_H_");
	   phase.add(" ");
	   
	   phase.add(PREPROCESSOR + INCLUDE + " \"" + this.getComponentName() + "_" + DEFINITION + HEADER + "\" " );
	   phase.add(" ");
	   
	   this.activePhase(phase);
	   
	   phase.add(" ");
	   phase.add(PREPROCESSOR + ENDIF + "/* " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PRIVATE_H_ */ ");

   }

    @Override
	public void activePhase(List<String> phase) {
	   
	   int loopVal	= 0 ;
	   int loopVal2	= 0 ;
	   
	   String[] otherComps;
	   int otherCompSize = ( otherComps = this.getOtherComponents()).length;
	   
	   for(loopVal = 0 ; loopVal < otherCompSize ; loopVal++) {
		   String otherComp = otherComps[loopVal];
		   phase.add(PREPROCESSOR + INCLUDE + " \"" + otherComp + "_" + PUBLIC + HEADER + "\" " );
	   }
	   
	   phase.add(" ");
	
	   String[] runableNames;
	   int runableNameSize = ( runableNames = this.runables.getRunableNames()).length;
	   
	   for(loopVal = 0 ; loopVal < runableNameSize ; loopVal++) 
	   {
		   String runableName = this.getComponentName() + "_ru" + runableNames[loopVal];
		   String returnType = this.runables.getRunableReturnTypes()[loopVal];
		   
		   StringBuilder runableVar = new StringBuilder();
		   
		   String[] runableVarTypes = null;
		   String[] runableVarNames = null;
		   
		   int runableVarTypeSize = ( runableVarTypes = this.runables.getRunableVarTypes()[loopVal] ).length;
		   int runableVarNameSize = ( runableVarNames = this.runables.getRunableVarNames()[loopVal] ).length;
		   
		   int runableVarSize = Math.min( runableVarTypeSize, runableVarNameSize ); 
		   
		   char endline = ' ';
		   
		   for( loopVal2 = 0 ; loopVal2 < runableVarSize ; loopVal2++ )
		   {
			   
			   if( loopVal2 == (runableVarSize - 1) ) {
				   endline = ' ';
			   }
			   else
			   {
				   endline = ',';
			   }
			   
			   runableVar.append( " " + runableVarTypes[loopVal2] + " " + runableVarNames[loopVal2] + endline );	
		   }
		   
		   phase.add("FUNC" + BRACELEFT + returnType + "," + runableName + BRACERIGHT + BRACELEFT + runableVar + BRACERIGHT + SEMICOLON);	
		   
	   }
	}
    
    public void sourceCommentPhase(List<String> phase) {
    }

    public void sourcePhase(List<String> phase) {
    }

    public String build()
    {	   
       List<String> phase = new ArrayList<String>();
       phase.add("/*************START OF FILE*********************/");
 	   this.headerCommentPhase(phase);
 	   this.headerPhase(phase);
 	   this.sourceCommentPhase(phase);
 	   this.sourcePhase(phase);
 	   phase.add("/*************END OF FILE***********************/");
 	   super.addLines(phase);
 	   
 	   return super.build();   
    }
    

}
