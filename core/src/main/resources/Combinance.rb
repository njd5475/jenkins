#!/usr/bin/env ruby

found = {}
Dir.glob("**/*.properties") do |file|
  if file.match(/\w+_\w{2}\.properties/) then
    filename = File.basename(file)
    locale = filename.match(/(_\w{2})+/)
    fileName = filename.match(/(?!_[A-Za-z0-9]{2})[A-Za-z0-9-]+/)
    puts "Locale: #{locale[0]}\tFileName: #{fileName}\t\tFullName: #{filename}"
    #found[fileName[0]] ||= {}
    found[locale[0]] ||= []
    found[locale[0]] << file
  end
end

require "json"
puts JSON.pretty_generate(found)

found.reduce({}) do |memo, (key, value)|
  puts "#{key}: #{value}"
  `cat #{value.join(" ")} > LocalizedMessages#{key}.properties`
end