function $id(selector) {
	if (typeof selector == "string") {
		return $("#" + selector);
	}
}