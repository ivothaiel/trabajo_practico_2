package ar.edu.unju.fi.ejercicio6.model;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles.Lookup;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FelinoDomestico {
     private String Nombre;
     private byte Edad;
     private float Peso;
     
	public FelinoDomestico() {
		super();
	}

	public FelinoDomestico(String nombre, byte edad, float peso) {
		super();
		Nombre = nombre;
		Edad = edad;
		Peso = peso;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public byte getEdad() {
		return Edad;
	}

	public void setEdad(byte edad) {
		Edad = edad;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoDomestico [Nombre=" + Nombre + ", Edad=" + Edad + ", Peso=" + Peso + ", getNombre()="
				+ getNombre() + ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Edad, Nombre, Peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FelinoDomestico other = (FelinoDomestico) obj;
		return Edad == other.Edad && Objects.equals(Nombre, other.Nombre)
				&& Float.floatToIntBits(Peso) == Float.floatToIntBits(other.Peso);
	}

	public int length() {
		return Nombre.length();
	}

	public boolean isEmpty() {
		return Nombre.isEmpty();
	}

	public char charAt(int index) {
		return Nombre.charAt(index);
	}

	public int codePointAt(int index) {
		return Nombre.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return Nombre.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return Nombre.codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return Nombre.offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		Nombre.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		Nombre.getBytes(srcBegin, srcEnd, dst, dstBegin);
	}

	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return Nombre.getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return Nombre.getBytes(charset);
	}

	public byte[] getBytes() {
		return Nombre.getBytes();
	}

	public boolean contentEquals(StringBuffer sb) {
		return Nombre.contentEquals(sb);
	}

	public boolean contentEquals(CharSequence cs) {
		return Nombre.contentEquals(cs);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return Nombre.equalsIgnoreCase(anotherString);
	}

	public int compareTo(String anotherString) {
		return Nombre.compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return Nombre.compareToIgnoreCase(str);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return Nombre.regionMatches(toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return Nombre.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean startsWith(String prefix, int toffset) {
		return Nombre.startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return Nombre.startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return Nombre.endsWith(suffix);
	}

	public int indexOf(int ch) {
		return Nombre.indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex) {
		return Nombre.indexOf(ch, fromIndex);
	}

	public int lastIndexOf(int ch) {
		return Nombre.lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		return Nombre.lastIndexOf(ch, fromIndex);
	}

	public int indexOf(String str) {
		return Nombre.indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return Nombre.indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return Nombre.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return Nombre.lastIndexOf(str, fromIndex);
	}

	public String substring(int beginIndex) {
		return Nombre.substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return Nombre.substring(beginIndex, endIndex);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return Nombre.subSequence(beginIndex, endIndex);
	}

	public String concat(String str) {
		return Nombre.concat(str);
	}

	public String replace(char oldChar, char newChar) {
		return Nombre.replace(oldChar, newChar);
	}

	public boolean matches(String regex) {
		return Nombre.matches(regex);
	}

	public boolean contains(CharSequence s) {
		return Nombre.contains(s);
	}

	public String replaceFirst(String regex, String replacement) {
		return Nombre.replaceFirst(regex, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return Nombre.replaceAll(regex, replacement);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return Nombre.replace(target, replacement);
	}

	public String[] split(String regex, int limit) {
		return Nombre.split(regex, limit);
	}

	public String[] split(String regex) {
		return Nombre.split(regex);
	}

	public String toLowerCase(Locale locale) {
		return Nombre.toLowerCase(locale);
	}

	public String toLowerCase() {
		return Nombre.toLowerCase();
	}

	public String toUpperCase(Locale locale) {
		return Nombre.toUpperCase(locale);
	}

	public String toUpperCase() {
		return Nombre.toUpperCase();
	}

	public String trim() {
		return Nombre.trim();
	}

	public String strip() {
		return Nombre.strip();
	}

	public String stripLeading() {
		return Nombre.stripLeading();
	}

	public String stripTrailing() {
		return Nombre.stripTrailing();
	}

	public boolean isBlank() {
		return Nombre.isBlank();
	}

	public Stream<String> lines() {
		return Nombre.lines();
	}

	public String indent(int n) {
		return Nombre.indent(n);
	}

	public String stripIndent() {
		return Nombre.stripIndent();
	}

	public String translateEscapes() {
		return Nombre.translateEscapes();
	}

	public <R> R transform(Function<? super String, ? extends R> f) {
		return Nombre.transform(f);
	}

	public IntStream chars() {
		return Nombre.chars();
	}

	public IntStream codePoints() {
		return Nombre.codePoints();
	}

	public char[] toCharArray() {
		return Nombre.toCharArray();
	}

	public String formatted(Object... args) {
		return Nombre.formatted(args);
	}

	public String intern() {
		return Nombre.intern();
	}

	public String repeat(int count) {
		return Nombre.repeat(count);
	}

	public Optional<String> describeConstable() {
		return Nombre.describeConstable();
	}

	public String resolveConstantDesc(Lookup lookup) {
		return Nombre.resolveConstantDesc(lookup);
	}
     
	
     
}
