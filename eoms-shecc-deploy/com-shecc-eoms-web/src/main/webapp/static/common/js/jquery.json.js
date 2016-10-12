(function ($) {
	'use strict';

	var escape = /["\\\x00-\x1f\x7f-\x9f]/g,
		meta = {
			'\b': '\\b',
			'\t': '\\t',
			'\n': '\\n',
			'\f': '\\f',
			'\r': '\\r',
			'"' : '\\"',
			'\\': '\\\\'
		},
		hasOwn = Object.prototype.hasOwnProperty;

	$.toJSON = typeof JSON === 'object' && JSON.stringify ? JSON.stringify : function (o) {
		if (o === null) {
			return 'null';
		}

		var pairs, k, name, val,
			type = $.type(o);

		if (type === 'undefined') {
			return undefined;
		}

		if (type === 'number' || type === 'boolean') {
			return String(o);
		}
		if (type === 'string') {
			return $.quoteString(o);
		}
		if (typeof o.toJSON === 'function') {
			return $.toJSON(o.toJSON());
		}
		if (type === 'date') {
			var month = o.getUTCMonth() + 1,
				day = o.getUTCDate(),
				year = o.getUTCFullYear(),
				hours = o.getUTCHours(),
				minutes = o.getUTCMinutes(),
				seconds = o.getUTCSeconds(),
				milli = o.getUTCMilliseconds();

			if (month < 10) {
				month = '0' + month;
			}
			if (day < 10) {
				day = '0' + day;
			}
			if (hours < 10) {
				hours = '0' + hours;
			}
			if (minutes < 10) {
				minutes = '0' + minutes;
			}
			if (seconds < 10) {
				seconds = '0' + seconds;
			}
			if (milli < 100) {
				milli = '0' + milli;
			}
			if (milli < 10) {
				milli = '0' + milli;
			}
			return '"' + year + '-' + month + '-' + day + 'T' +
				hours + ':' + minutes + ':' + seconds +
				'.' + milli + 'Z"';
		}

		pairs = [];

		if ($.isArray(o)) {
			for (k = 0; k < o.length; k++) {
				pairs.push($.toJSON(o[k]) || 'null');
			}
			return '[' + pairs.join(',') + ']';
		}

		if (typeof o === 'object') {
			for (k in o) {
				if (hasOwn.call(o, k)) {
					type = typeof k;
					if (type === 'number') {
						name = '"' + k + '"';
					} else if (type === 'string') {
						name = $.quoteString(k);
					} else {
						continue;
					}
					type = typeof o[k];

					if (type !== 'function' && type !== 'undefined') {
						val = $.toJSON(o[k]);
						pairs.push(name + ':' + val);
					}
				}
			}
			return '{' + pairs.join(',') + '}';
		}
	};

	$.evalJSON = typeof JSON === 'object' && JSON.parse ? JSON.parse : function (str) {
		return eval('(' + str + ')');
	};

	$.secureEvalJSON = typeof JSON === 'object' && JSON.parse ? JSON.parse : function (str) {
		var filtered =
			str
			.replace(/\\["\\\/bfnrtu]/g, '@')
			.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']')
			.replace(/(?:^|:|,)(?:\s*\[)+/g, '');

		if (/^[\],:{}\s]*$/.test(filtered)) {
			return eval('(' + str + ')');
		}
		throw new SyntaxError('Error parsing JSON, source is not valid.');
	};

	$.quoteString = function (str) {
		if (str.match(escape)) {
			return '"' + str.replace(escape, function (a) {
				var c = meta[a];
				if (typeof c === 'string') {
					return c;
				}
				c = a.charCodeAt();
				return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
			}) + '"';
		}
		return '"' + str + '"';
	};

	$.formatJSON = function (json) {
		var reg = null, formatted = '', pad = 0, PADDING = '    '; // one can also
		// begin formatting...
		if (typeof json !== 'string') {
			// make sure we start with the JSON as a string
			json = JSON.stringify(json);
		} else {
			// is already a string, so parse and re-stringify in order to remove
			// extra whitespace
			json = JSON.parse(json);
			json = JSON.stringify(json);
		}
		// add newline before and after curly braces
		reg = /([\{\}])/g;
		json = json.replace(reg, '\r\n$1\r\n');
		
		// add newline before and after square brackets
		reg = /([\[\]])/g;
		json = json.replace(reg, '\r\n$1\r\n');
		
		// add newline after comma
		reg = /(\,)/g;
		json = json.replace(reg, '$1\r\n');
		
		// remove multiple newlines
		reg = /(\r\n\r\n)/g;
		json = json.replace(reg, '\r\n');
		
		// remove newlines before commas
		reg = /\r\n\,/g;
		json = json.replace(reg, ',');
		
		$.each(json.split('\r\n'), function(index, node) {
			var i = 0, indent = 0, padding = '';
			
			if (node.match(/\{$/) || node.match(/\[$/)) {
				indent = 1;
			} else if (node.match(/\}/) || node.match(/\]/)) {
				if (pad !== 0) {
					pad -= 1;
				}
			} else {
				indent = 0;
			}
			
			for (i = 0; i < pad; i++) {
				padding += PADDING;
			}
			
			formatted += padding + node + '\r\n';
			pad += indent;
		});
		
		return formatted;
	};
}(jQuery));
