package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CodeGenerator implements Components 
{
   private List<String> codeLines;
   
   protected LocalDate date;
   protected String author;
   protected String[] otherComponents;  
   
   protected Runable runables; 
   
   private String componentName;
   private String fileName;

   public CodeGenerator(String _compName , String _author , String[] _otherComps , Runable _runable ) {
      this.componentName = _compName;
      this.author = _author;
      
      this.otherComponents = _otherComps;
      this.runables = _runable;
      
      this.setCodeLines(new ArrayList<String>());
      this.date = LocalDate.now();
   }

   public String getComponentName() {
      return this.componentName;
   }

   public void setComponentName(String _componentName) {
      this.componentName = _componentName;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String fileName) {
      this.fileName = fileName;
   }
   
   public String[] getOtherComponents() {
		return otherComponents;
	}

	public void setOtherComponents(String[] otherComponents) {
		this.otherComponents = otherComponents;
	}
	
   /* Methods */
   public List<String> getCodeLines() {
      return this.codeLines;
   }

   public void setCodeLines(List<String> codeLines) {
      this.codeLines = codeLines;
   }

   public String getAuthor() {
      return this.author;
   }

   public void setAuthor(String _author) {
      this.author = _author;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public void setDate(LocalDate _date) {
      this.date = _date;
   }

   public void addLine(String line) {
      this.getCodeLines().add(line);
   }

   public void addLines(List<String> lines) {
      this.getCodeLines().addAll(lines);
   }

   
   public String build() {
	   
      StringBuilder stringBuilder = new StringBuilder();
      Iterator<String> code = this.getCodeLines().iterator();

      while(code.hasNext()) {
         String line = (String)code.next();
         stringBuilder.append(line).append("\n");
      }
   
      return stringBuilder.toString();
   }
   
   

}
