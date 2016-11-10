package ar.com.Request.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Request {
	
		private List<Object> list = new ArrayList<Object>();		
		private Object object;
		private Serializable id;
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

		public Serializable getId() {
			return id;
		}
		public void setId(Serializable id) {
			this.id = id;
		}
		public Object getObject() {
			return object;
		}

	}

