package com.example.assignmentflight.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentflight.R
import com.example.assignmentflight.models.FlightListItem

/**
 * @author Ishwari Sorthe
 * Adapter for recycle view to display the flightListItem
 */
class FlightAdapter(flightListItems: List<FlightListItem>, private var context: Context) :
    RecyclerView.Adapter<FlightAdapter.FlightAdapterHolder>() {

    private var flightListItem = flightListItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightAdapterHolder {
        val rootView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.flight_view_layout, parent, false)
        return FlightAdapterHolder(rootView)
    }

    override fun onBindViewHolder(holder: FlightAdapterHolder, position: Int) {

        holder.bind(flightListItem[position], context)
    }

    override fun getItemCount(): Int = flightListItem.size

    class FlightAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var missionName: TextView = itemView.findViewById(R.id.mission_id)
        private var textYear: TextView = itemView.findViewById(R.id.text_year_value)
        private var textUtcDateValue: TextView = itemView.findViewById(R.id.text_utc_date_value)
        private var textLocalDateValue: TextView = itemView.findViewById(R.id.text_local_date_value)
        private var rocketIdValue: TextView = itemView.findViewById(R.id.rocket_id_value)
        private var rocketName: TextView = itemView.findViewById(R.id.rocket_name_value)
        private var rocketType: TextView = itemView.findViewById(R.id.rocket_type_value)
        private var siteId: TextView = itemView.findViewById(R.id.nationality_value)
        private var siteName: TextView = itemView.findViewById(R.id.manufacturer_value)
        private var imageViewSmall: ImageView = itemView.findViewById(R.id.small_mission_image)
        private var imageViewLarge: ImageView = itemView.findViewById(R.id.large_mission_image)
        private var moreDetailsData: TextView = itemView.findViewById(R.id.more_details_value)


        fun bind(flightListItem: FlightListItem, context: Context) {

            missionName.text = flightListItem.mission_name
            textYear.text = flightListItem.launch_year
            textUtcDateValue.text = flightListItem.launch_date_utc
            textLocalDateValue.text = flightListItem.launch_date_local
            rocketIdValue.text = flightListItem.rocket.rocket_id
            rocketName.text = flightListItem.rocket.rocket_name
            rocketType.text = flightListItem.rocket.rocket_type
            siteId.text = flightListItem.launch_site.site_id
            siteName.text = flightListItem.launch_site.site_name

            (context.getString(R.string.artical_link) + flightListItem.links.article_link
                    + context.getString(R.string.wikipedia) + flightListItem.links.wikipedia
                    + context.getString(R.string.video_link) + flightListItem.links.video_link
                    ).also { moreDetailsData.text = it }

            Glide.with(context)
                .load(flightListItem.links.mission_patch_small)
                .into(imageViewSmall)

            Glide.with(context)
                .load(flightListItem.links.mission_patch)
                .into(imageViewLarge)
        }
    }
}