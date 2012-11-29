package com.elefante.enums;

public enum OrderFields {
	REF {
		@Override
		public String field() {

			return "referenceNumber";
		}
	},
	DATE {
		@Override
		public String field() {
			return "creationDate";
		}
	},
	PRODUCT {
		@Override
		public String field() {
			return "product";
		}
	},
	TOTAL {
		@Override
		public String field() {
			return "total";
		}
	},
	STATE {
		@Override
		public String field() {
			return "state";
		}
	};

	public abstract String field();

}
