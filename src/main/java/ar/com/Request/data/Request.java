package ar.com.Request.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Request {
	
		private List<Object> list = new ArrayList<Object>();
		
		public Request(){}
		private Class object;
		private Serializable id;
		public List<Object> getList() {
			return list;
		}

		public void setList(List obj) {
			this.list=obj;
		}
		public void setObject(Class object){
			this.object=object;
		}

		public Class getObject() {
			return object;
		}

		
	}

