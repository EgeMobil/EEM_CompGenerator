package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceGen extends CodeGenerator implements Namespaces, Functionallity {
   
   private String[] runabeleFileNames;
   private int runableCount;

   public SourceGen(String _compName, String _author , String[] _otherComps, Runable _runable) {
	  super(_compName, _author, _otherComps, _runable);
	  runableCount = 0;
	  runnableNamesGeneration();
   }
   
   public int getRunableCount() {
		return runableCount;
	}

	public void setRunableCount(int runableCount) {
		this.runableCount = runableCount;
	}
   
   public void runnableNamesGeneration() {
      this.runabeleFileNames = new String[this.runables.getRunableNames().length];

      for(int loopVal = 0; loopVal < this.runables.getRunableNames().length; ++loopVal) 
      {
         String fileName = super.getComponentName().toString();
         this.runabeleFileNames[loopVal] = fileName + "_ru" + this.runables.getRunableNames()[loopVal] + ".c";
      }

   }

   public String toString() {
      return "Runnable file names: " + Arrays.toString(this.runabeleFileNames);
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + ".c";
      return fileName;
   }

   @Override
   public void headerCommentPhase(List<String> phase) {
	   
	   this.setDate(LocalDate.now());
	   phase.add("/* ");
	   phase.add(" * " + this.runabeleFileNames[this.runableCount] );
	   phase.add(" * ");
	   phase.add(" *  Created on: " + String.valueOf(this.getDate()));
	   phase.add(" *      Author: " + this.getAuthor());
	   phase.add("*/ ");
	   phase.add(" ");
	   
   }

   public void headerPhase(List<String> phase) {
	   
	   phase.add(PREPROCESSOR + INCLUDE + " \"" + this.getComponentName() + "_" + PRIVATE + HEADER + "\" " );
	   phase.add(" ");
	   
	   /* Local defines will be here */
	   this.activePhase(phase);
	   
	   phase.add(" ");
	   phase.add("/* " + this.getComponentName().toUpperCase() + "_SRC_" + this.runabeleFileNames[this.runableCount].toUpperCase() + " */ ");
	   phase.add(" ");
   }

   public void sourceCommentPhase(List<String> phase) {
	      
	   phase.add("/* ");
	   phase.add(" *  " + this.runabeleFileNames[this.runableCount] );
	   phase.add(" * ");
	   phase.add(" *  Interfaces : Ports ");
	   
	   String[] runableVarTypes = null;
	   String[] runableVarNames = null;
	   
	   int runableVarTypeSize = ( runableVarTypes = this.runables.getRunableVarTypes()[this.runableCount] ).length;
	   int runableVarNameSize = ( runableVarNames = this.runables.getRunableVarNames()[this.runableCount] ).length;
	   int runableVarSize = Math.min( runableVarTypeSize, runableVarNameSize );
			   
	   for(int loopVal = 0 ; loopVal < runableVarSize ; loopVal++ )
	   {
		   phase.add(" *  " + runableVarTypes[loopVal] + " : " + runableVarNames[loopVal] );
	   }
	   
	   phase.add(" * ");
	   phase.add(" *  Created on: " + String.valueOf(this.getDate()));
	   phase.add(" * ");
	   phase.add(" *  Description : ");
	   phase.add(" *  " + this.runables.getRunableDescriptions()[this.runableCount] );
	   phase.add("*/ ");
	   phase.add(" ");
	   
   }

   public void sourcePhase(List<String> phase) 
   {
	   int loopVal	= 0 ;
	   
	   String[] runableNames;
	   int runableNameSize = ( runableNames = this.runables.getRunableNames()).length;
	   
	   String runableName = this.getComponentName() + "_ru" + runableNames[this.runableCount];
	   String returnType = this.runables.getRunableReturnTypes()[this.runableCount];
	   
	   StringBuilder runableVar = new StringBuilder();
	   
	   String[] runableVarTypes = null;
	   String[] runableVarNames = null;
	   
	   int runableVarTypeSize = ( runableVarTypes = this.runables.getRunableVarTypes()[this.runableCount] ).length;
	   int runableVarNameSize = ( runableVarNames = this.runables.getRunableVarNames()[this.runableCount] ).length;
	   
	   int runableVarSize = Math.min( runableVarTypeSize, runableVarNameSize ); 
	   
	   char endline = ' ';
	   
	   for( loopVal = 0 ; loopVal < runableVarSize ; loopVal++ )
	   {
	      
	      if( loopVal == (runableVarSize - 1) ) {
	   	   endline = ' ';
	      }
	      else
	      {
	   	   endline = ',';
	      }
	      
	      runableVar.append( " " + runableVarTypes[loopVal] + " " + runableVarNames[loopVal] + endline );	
	   }
	   
	   phase.add("FUNC" + BRACELEFT + returnType + "," + runableName + BRACERIGHT + BRACELEFT + runableVar + BRACERIGHT + SEMICOLON);	
	   phase.add(CURLYLEFT);
	   phase.add(" ");
	   phase.add(" ");
	   phase.add(" ");
	   phase.add(" ");
	   phase.add(BRACERIGHT);
	   phase.add(" ");
	   phase.add(" ");
   }

   public void activePhase(List<String> phase) {
	   /* Local defines will be handle here later */
   }
   
   public String build()
   {	  
	   List<String> runableSet = new ArrayList<String>();
	   
	   /* Build source for all runnable files */
	   for(this.runableCount = 0 ; this.runableCount < this.runables.getRunableNames().length ; this.runableCount++)
	   {
		   List<String> phase = new ArrayList<String>();
		   phase.add("/*************START OF FILE*********************/");
		   this.headerCommentPhase(phase);
		   this.headerPhase(phase);
		   this.sourceCommentPhase(phase);
		   this.sourcePhase(phase);
		   phase.add("/*************END OF FILE***********************/");
		   super.addLines(phase);   
		   
		   runableSet.add(super.build());	
		   
		   /* Clear Codespace for next runable */
		   phase.clear();
		   super.setCodeLines(phase);
	   }
	   
	     
	   return runableSet.toString();   
   }

}
