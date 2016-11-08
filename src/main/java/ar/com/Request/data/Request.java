package ar.com.Request.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Request {
	
		private List<Object> list = new ArrayList<Object>();		
		private Object object;
		private String id;
		public Request(){}
		public List<Object> getList() {
			return list;
		}

		public void setList(List obj) {
			this.list=obj;
		}
		public void setObject(Object object){
			this.object=object;
		}

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Object getObject() {
			return object;
		}

	}

