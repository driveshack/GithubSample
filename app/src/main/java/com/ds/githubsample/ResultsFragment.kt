package com.ds.githubsample


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.githubsample.MainActivity.Companion.GithubToken
import kotlinx.android.synthetic.main.fragment_results.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.Future

class ResultsFragment : Fragment() {

    var issueTitles = ArrayList<String>()
    var idLabels = ArrayList<String>()
    var nodeLabels = ArrayList<String>()
    var urlLabels = ArrayList<String>()
    var nameLabels = ArrayList<String>()
    var colorLabels = ArrayList<String>()
    var defaultLabels = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val connection = URL("https://api.github.com/repos/driveshack/PublicRepo/issues").openConnection() as HttpURLConnection
        connection.addRequestProperty("Authorization", "Basic $GithubToken")

        val call = {
            connection.connect()
            connection.inputStream.reader().readText()
        }

        val future : Future<String>  = Executors.newSingleThreadExecutor().submit(call)

        val jsonArray = JSONArray(future.get())

        for(i in 0 until jsonArray.length()){
            val issue = jsonArray.getJSONObject(i)
            issueTitles.add(issue.getString("title"))
            var labelsArray = issue.getJSONArray("labels")
            var labels = labelsArray.getJSONObject(0)
            idLabels.add(labels.getString("id"))
            nodeLabels.add(labels.getString("node_id"))
            urlLabels.add(labels.getString("url"))
            nameLabels.add(labels.getString("name"))
            colorLabels.add(labels.getString("color"))
            defaultLabels.add(labels.getString("default"))
        }

        result_list.adapter = RecyclerAdapter(issueTitles, idLabels, nodeLabels, urlLabels, nameLabels, colorLabels, defaultLabels)
        result_list.layoutManager = LinearLayoutManager(activity)
    }
}
