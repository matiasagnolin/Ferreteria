package ar.com.Request.data;

import java.util.ArrayList;
import java.util.List;
public class Request {
		private List<Object> list = new ArrayList<Object>();
		
		public Request(){}

		public List<Object> getList() {
			return list;
		}

		public void setList(List obj) {
			this.list=obj;
		}
	}

