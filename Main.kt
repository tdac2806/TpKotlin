fun main() {
   var str = listOf("a","b","c")
   print(joinOption(str))
}

fun joinToString(
   separator: String =", ",
   prefix: String ="",
   postfix: String = ""
): String
{
   return ""
}

fun joinOption(options: Collection<String>)=
   options.joinToString(prefix="[",separator=",",postfix="]")