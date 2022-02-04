package Util

class ARGSManager
{
    companion object
    {
        private val argRequests = mutableMapOf<String, () -> Unit>()

        /**
         * argRequest | argValue
         * -s         | file.txt
         */
        fun manageArgs(args: Array<String>, action: (argsValues: List<String>) -> Unit)
        {
            val argsValues = mutableListOf<String>()
            args.forEach()
            {
                if (it.startsWith("-")) { if (argRequests.containsKey(it)) argRequests[it]!!.invoke() else println("[Alert] {ARGSManager} {managerArgs} action for argRequest: $it, not found") }
                else argsValues.add(it)
            }

            action(argsValues)
        }

        fun onArg(arg: String, action: () -> Unit) = argRequests.put(arg, action)

    }
}