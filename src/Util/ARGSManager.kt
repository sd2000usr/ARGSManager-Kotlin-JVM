package Util

class ARGSManager
{
    companion object
    {
        private val argRequests = mutableMapOf<String, () -> Unit>()
        private var onArgRequestUnAssignedFoundEvent: (arg: String) -> Unit = {}

        /**
         * argRequest | argValue
         * -s         | file.txt
         */
        fun manageArgs(args: Array<String>, action: (argsValues: List<String>) -> Unit)
        {
            val argsValues = mutableListOf<String>()
            args.forEach()
            {
                if (it.startsWith("-")) { if (argRequests.containsKey(it)) argRequests[it]!!.invoke() else onArgRequestUnAssignedFoundEvent(it) }
                else argsValues.add(it)
            }

            action(argsValues)
        }

        fun onArgRequestFound(arg: String, action: () -> Unit) = argRequests.put(arg, action)
        fun onArgRequestUnAssignedFound(arg: String, action: (arg: String) -> Unit) = run { onArgRequestUnAssignedFoundEvent = action }




    }
}